package com.example.bookstore.controller;

import com.example.bookstore.dto.BookRequest;
import com.example.bookstore.exception.ResourceNotFoundException;
import com.example.bookstore.model.Author;
import com.example.bookstore.model.Book;
import com.example.bookstore.repository.AuthorRepository;
import com.example.bookstore.repository.BookRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @GetMapping
    public Page<Book> list(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice,
            Pageable pageable
    ) {
        Specification<Book> spec = Specification.where(null);

        if (title != null && !title.isBlank()) {
            spec = spec.and((root, query, cb) -> cb.like(cb.lower(root.get("title")), "%" + title.toLowerCase() + "%"));
        }
        if (author != null && !author.isBlank()) {
            spec = spec.and((root, query, cb) -> {
                var join = root.join("author");
                return cb.like(cb.lower(join.get("name")), "%" + author.toLowerCase() + "%");
            });
        }
        if (year != null) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("publishedYear"), year));
        }
        if (minPrice != null) {
            spec = spec.and((root, query, cb) -> cb.greaterThanOrEqualTo(root.get("price"), minPrice));
        }
        if (maxPrice != null) {
            spec = spec.and((root, query, cb) -> cb.lessThanOrEqualTo(root.get("price"), maxPrice));
        }

        return bookRepository.findAll(spec, pageable);
    }

    @GetMapping("/{id}")
    public Book get(@PathVariable Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found: " + id));
    }

    @PostMapping
    public ResponseEntity<Book> create(@Valid @RequestBody BookRequest req) {
        Author author = authorRepository.findById(req.getAuthorId())
                .orElseThrow(() -> new ResourceNotFoundException("Author not found: " + req.getAuthorId()));
        Book book = new Book();
        book.setTitle(req.getTitle());
        book.setIsbn(req.getIsbn());
        book.setPublishedYear(req.getPublishedYear());
        book.setPrice(req.getPrice());
        book.setAuthor(author);
        Book saved = bookRepository.save(book);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable Long id, @Valid @RequestBody BookRequest req) {
        Author author = authorRepository.findById(req.getAuthorId())
                .orElseThrow(() -> new ResourceNotFoundException("Author not found: " + req.getAuthorId()));

        return bookRepository.findById(id).map(existing -> {
            existing.setTitle(req.getTitle());
            existing.setIsbn(req.getIsbn());
            existing.setPublishedYear(req.getPublishedYear());
            existing.setPrice(req.getPrice());
            existing.setAuthor(author);
            return bookRepository.save(existing);
        }).orElseThrow(() -> new ResourceNotFoundException("Book not found: " + id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return bookRepository.findById(id).map(existing -> {
            bookRepository.delete(existing);
            return ResponseEntity.noContent().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Book not found: " + id));
    }
}

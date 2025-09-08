package com.example.bookstore.controller;

import com.example.bookstore.exception.ResourceNotFoundException;
import com.example.bookstore.model.Author;
import com.example.bookstore.repository.AuthorRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping
    public Page<Author> list(@RequestParam(required = false) String name, Pageable pageable) {
        if (name != null && !name.isBlank()) {
            return authorRepository.findByNameContainingIgnoreCase(name, pageable);
        }
        return authorRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Author get(@PathVariable Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found: " + id));
    }

    @PostMapping
    public ResponseEntity<Author> create(@Valid @RequestBody Author author) {
        Author saved = authorRepository.save(author);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public Author update(@PathVariable Long id, @Valid @RequestBody Author updated) {
        return authorRepository.findById(id).map(existing -> {
            existing.setName(updated.getName());
            existing.setBio(updated.getBio());
            return authorRepository.save(existing);
        }).orElseThrow(() -> new ResourceNotFoundException("Author not found: " + id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return authorRepository.findById(id).map(existing -> {
            authorRepository.delete(existing);
            return ResponseEntity.noContent().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Author not found: " + id));
    }
}

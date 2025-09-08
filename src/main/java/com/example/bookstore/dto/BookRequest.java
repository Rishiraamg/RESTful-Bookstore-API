package com.example.bookstore.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public class BookRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String isbn;

    @Min(0)
    private Integer publishedYear;

    @DecimalMin(value = "0.0", inclusive = true)
    @Digits(integer=10, fraction=2)
    private BigDecimal price;

    @NotNull
    private Long authorId;

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public Integer getPublishedYear() { return publishedYear; }
    public void setPublishedYear(Integer publishedYear) { this.publishedYear = publishedYear; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public Long getAuthorId() { return authorId; }
    public void setAuthorId(Long authorId) { this.authorId = authorId; }
}

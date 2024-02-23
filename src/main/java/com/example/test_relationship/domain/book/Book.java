package com.example.test_relationship.domain.book;

import com.example.test_relationship.domain.author.Author;
import com.example.test_relationship.domain.category.Category;
import com.example.test_relationship.domain.photo.Photo;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "isBn")
    private String isbn;

    @Column(name = "total_pages")
    private String totalPages;

    @Column(name = "rating")
    private String rating;

    @Column(name = "published_date")
    private String publishedDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "photo_id")
    private Photo photo;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "books_categories",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "books_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors;

    @Builder
    public Book(Long id, String title, String isbn, String totalPages, String rating, String publishedDate, Photo photo, List<Category> categories, List<Author> authors) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.totalPages = totalPages;
        this.rating = rating;
        this.publishedDate = publishedDate;
        this.photo = photo;
        this.categories = categories;
        this.authors = authors;
    }
}

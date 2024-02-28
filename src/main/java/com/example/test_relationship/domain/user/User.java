package com.example.test_relationship.domain.user;

import com.example.test_relationship.domain.book.Book;
import com.example.test_relationship.domain.role.Role;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToMany
    @JoinTable(
            name = "user_books",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> books;

    @Builder
    public User(Long id, String username, String password, Role role, List<Book> books) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.books = books;
    }
}

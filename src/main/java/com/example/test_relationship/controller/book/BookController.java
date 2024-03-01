package com.example.test_relationship.controller.book;

import com.example.test_relationship.domain.book.Book;
import com.example.test_relationship.payload.book.BookRequest;
import com.example.test_relationship.service.book.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    @GetMapping("/books")
    public ResponseEntity<?> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<?> getBookById(@PathVariable("id") Long id) throws Throwable{
        return ResponseEntity.ok(bookService.getBookById(id));

    }

    @PostMapping("/books")
    public ResponseEntity<?> createBook(@RequestBody @Valid BookRequest payload) throws Throwable{
        bookService.createBook(payload);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @PatchMapping ("/books/{id}")
    public ResponseEntity<?> updateBook(@PathVariable("id") Long id, @RequestBody @Valid BookRequest payload) throws Throwable{
        bookService.updateBook(id, payload);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(bookService.deleteBookById(id));
    }

}

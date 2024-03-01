package com.example.test_relationship.service.book;

import com.example.test_relationship.domain.book.Book;
import com.example.test_relationship.payload.book.BookRequest;

public interface BookService {

    Object getAllBooks();

    Object getBookById(Long id) throws Throwable;

    void createBook(BookRequest payload) throws Throwable;

    void updateBook(Long id, BookRequest payload);

    Object deleteBookById(Long id);
}

package com.example.test_relationship.service.book;

import com.example.test_relationship.domain.author.Author;
import com.example.test_relationship.domain.author.AuthorRepository;
import com.example.test_relationship.domain.book.Book;
import com.example.test_relationship.domain.book.BookRepository;
import com.example.test_relationship.domain.category.Category;
import com.example.test_relationship.domain.category.CategoryRepository;
import com.example.test_relationship.domain.photo.Photo;
import com.example.test_relationship.domain.photo.PhotoRepository;
import com.example.test_relationship.payload.book.BookRequest;
import com.example.test_relationship.payload.photo.PhotoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;
    private final PhotoRepository photoRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Object getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Object getBookById(Long id) throws Throwable {
        return bookRepository.findById(id);
    }

    @Override
    public void createBook(BookRequest payload) throws Throwable {


        var authors = payload.authors().stream().map(
                author -> Author.builder()
                        .firstName(author.firstName())
                        .lastName(author.lastName())
                        .birthDate(author.birthDate().format(DateTimeFormatter.ofPattern("yyyyMMdd")))
                        .build()
        ).collect(Collectors.toList());


        var categories = payload.categories().stream().map(
                category -> Category.builder()
                        .name(category.name())
                        .build()
        ).collect(Collectors.toList());


        Book book = Book.builder()
                .title(payload.title())
                .isbn(payload.isbn())
                .rating(payload.rating())
                .totalPages(payload.totalPages())
                .publishedDate(payload.publishedDate().format(DateTimeFormatter.ofPattern("yyyyMMdd")))
                .photo(Photo.builder()
                        .urlSmall(payload.photos().urlSmall())
                        .urlMedium(payload.photos().urlMedium())
                        .urlLarge(payload.photos().urlLarge())
                        .build())
                .categories(categories)
                .authors(authors)
                .build();

        bookRepository.save(book);
    }

    @Override
    public void updateBook(Long id, BookRequest payload) {
        var authors = payload.authors().stream().map(
                author -> Author.builder()
                        .firstName(author.firstName())
                        .lastName(author.lastName())
                        .birthDate(author.birthDate().format(DateTimeFormatter.ofPattern("yyyyMMdd")))
                        .build()
        ).collect(Collectors.toList());


        var categories = payload.categories().stream().map(
                category -> Category.builder()
                        .name(category.name())
                        .build()
        ).collect(Collectors.toList());


        var bookId = bookRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Not found id"));
            bookId.setTitle(payload.title());
            bookId.setIsbn(payload.isbn());
            bookId.setTotalPages(payload.totalPages());
            bookId.setRating(payload.rating());
            bookId.setPublishedDate(payload.publishedDate().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
            bookId.setPhoto(
                    Photo.builder()
                        .urlLarge(payload.photos().urlLarge())
                        .urlMedium(payload.photos().urlMedium())
                        .urlSmall(payload.photos().urlSmall()).build());
        bookId.setCategories(categories);
        bookId.setAuthors(authors);
//        bookId.setAuthors(authorRepository.findAuthorById().stream()
//                .map(author -> Author.builder()
//                        .firstName(author.getFirstName())
//                        .lastName(author.getLastName())
//                        .birthDate(author.getBirthDate())
//                        .build()
//                ).collect(Collectors.toList()));

        bookRepository.save(bookId);
    }


}

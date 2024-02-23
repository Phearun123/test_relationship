package com.example.test_relationship.payload.book;

import com.example.test_relationship.domain.category.Category;
import com.example.test_relationship.domain.photo.Photo;
import com.example.test_relationship.payload.author.AuthorRequest;
import com.example.test_relationship.payload.category.CategoryRequest;
import com.example.test_relationship.payload.photo.PhotoRequest;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public record BookRequest(

        @JsonProperty("title")
        @NotNull
        String title,
        @JsonProperty("isbn")
        String isbn,
        @JsonProperty("total_pages")
        String totalPages,
        @JsonProperty("rating")
        String rating,
        @JsonProperty("published_date")
        @DateTimeFormat(pattern = "yyyyMMdd")
        LocalDate publishedDate,
        @JsonProperty("photo_id")
        PhotoRequest photos,
        @JsonProperty("category")
        @NotNull
        List<CategoryRequest> categories,
        @JsonProperty("author")
        @NotNull
        List<AuthorRequest> authors
){

}

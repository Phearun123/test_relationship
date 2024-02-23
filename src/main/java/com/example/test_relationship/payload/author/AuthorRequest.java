package com.example.test_relationship.payload.author;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

public record AuthorRequest(

        @JsonProperty("first_name")
        String firstName,
        @JsonProperty("last_name")
        String lastName,
        @JsonProperty("published_date")
        @DateTimeFormat(pattern = "yyyyMMdd")
        LocalDate birthDate

) {
}

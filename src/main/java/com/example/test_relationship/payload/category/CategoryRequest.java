package com.example.test_relationship.payload.category;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CategoryRequest(

        @JsonProperty("category_name")
        String name

) {
}

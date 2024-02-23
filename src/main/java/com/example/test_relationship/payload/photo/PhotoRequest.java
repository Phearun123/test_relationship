package com.example.test_relationship.payload.photo;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PhotoRequest (

        @JsonProperty("url_small")
        String urlSmall,
        @JsonProperty("url_medium")
        String urlMedium,
        @JsonProperty("url_large")
        String urlLarge
){
}

package com.example.test_relationship.payload.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public record UserRequest(
        @NotBlank
        @JsonProperty("username")
        String username,
        @NotBlank
        @JsonProperty("password")
        String password

) {
}

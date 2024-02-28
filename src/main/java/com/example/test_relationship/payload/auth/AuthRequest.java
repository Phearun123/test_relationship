package com.example.test_relationship.payload.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AuthRequest(

        @NotBlank
        @Size(max = 50)
        @JsonProperty("username")
        String username,

        @NotBlank
        @Size(max = 50)
        @JsonProperty("password")
        String password

) {
}

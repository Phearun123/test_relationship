package com.example.test_relationship.payload.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AuthRequest(

        @NotBlank
        @Size(max = 50)
        @JsonProperty("user_id")
        String userId,

        @NotBlank
        @Size(max = 50)
        @JsonProperty("password")
        String password

) {
}

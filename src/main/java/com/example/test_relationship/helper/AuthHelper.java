package com.example.test_relationship.helper;

import com.example.test_relationship.domain.user.User;
import com.example.test_relationship.payload.user.SecurityUser;
import com.example.test_relationship.utils.PasswordUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Optional;

public class AuthHelper {

    public static Authentication getAuth() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static String getToken() {
        Jwt jwt = (Jwt) getAuth().getPrincipal();
        return jwt.getTokenValue();
    }

    public static Jwt getJwt() {
        if (getAuth().getPrincipal() instanceof Jwt) {
            return (Jwt) getAuth().getPrincipal();
        }
        return null;
    }

    public static <T> T getClaim(Jwt jwt, String claim) {

        if (jwt == null) {
            return null;
        }

        T value = null;

        if (jwt.hasClaim(claim)) {
            value = jwt.getClaim(claim);
        }

        return value;
    }

    public static Optional<SecurityUser> getSecurityUser() {
        var authentication = getAuth();

        if (authentication.getPrincipal() instanceof SecurityUser) {
            return Optional.ofNullable((SecurityUser) getAuth().getPrincipal());
        }

        return Optional.empty();
    }

    public static User getUser() {
        return getSecurityUser()
                .map(SecurityUser::user)
                .orElseThrow(IllegalAccessError::new);
    }

    public static Long getUserId() {
        return getUser().getId();
    }
}

package com.example.test_relationship.config;

import com.example.test_relationship.components.security.CustomJwtAuthenticationConverter;
import com.example.test_relationship.components.security.UnauthorizedHandler;
import com.example.test_relationship.properties.RsaKeyProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final RsaKeyProperties rsaKeyProperties;
    private final UnauthorizedHandler unauthorizedHandler;
    private final AccessDeniedHandler accessDeniedHandler;
    private final CustomJwtAuthenticationConverter customJwtAuthenticationConverter;

    @Bean
    public AuthenticationManager userAuthProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        var authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        authenticationProvider.setHideUserNotFoundExceptions(false);
        return new ProviderManager(authenticationProvider);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

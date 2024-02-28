package com.example.test_relationship.components.security;

import com.example.test_relationship.common.api.StatusCode;
import com.example.test_relationship.exception.BusinessException;
import com.example.test_relationship.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserAuthenticationProvider {

    private final AuthenticationManager authenticationManager;

    public UserAuthenticationProvider(@Qualifier("userAuthProvider") AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public Authentication authenticate(String username, String password) {
        try {
            var rawPwd = PasswordUtils.decrypt(password);
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, rawPwd));
        } catch (UsernameNotFoundException ex) {
            throw new BusinessException(ex.getMessage(), StatusCode.USER_NOT_FOUND);
        } catch (BadCredentialsException e) {
            throw new BusinessException(e, StatusCode.BAD_CREDENTIALS);
        } catch (DisabledException e) {
            throw new BusinessException(StatusCode.USER_DISABLED);
        } catch (LockedException e) {
            throw new BusinessException(StatusCode.USER_LOCKED);
        } catch (Exception e) {
            throw new BusinessException(StatusCode.PASSWORD_MUST_BE_ENCRYPTED);
        }

    }
}

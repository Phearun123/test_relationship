package com.example.test_relationship.service.auth;

import com.example.test_relationship.common.api.StatusCode;
import com.example.test_relationship.domain.role.Role;
import com.example.test_relationship.domain.user.User;
import com.example.test_relationship.domain.user.UserRepository;
import com.example.test_relationship.exception.BusinessException;
import com.example.test_relationship.payload.auth.AuthRequest;
import com.example.test_relationship.payload.user.UserRequest;
import com.example.test_relationship.utils.PasswordUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Object login(AuthRequest payload) throws Throwable {
        return null;
    }

    @Transactional
    @Override
    public void signup(UserRequest payload) throws Throwable {
        var findUser = userRepository.findUserByUserName(payload.username());
        if (findUser.isPresent()){
            throw new BusinessException(StatusCode.USER_ID_EXIST);
        }

        String rawPassword;
        try {
            rawPassword = passwordEncoder.encode(PasswordUtils.decrypt(payload.password()));
        } catch (Exception e) {
            throw new BusinessException(StatusCode.PASSWORD_MUST_BE_ENCRYPTED);
        }

        var user = User.builder()
                .username(payload.username())
                .password(rawPassword)
                .role(Role.USER)
                .build();

        userRepository.save(user);


    }
}

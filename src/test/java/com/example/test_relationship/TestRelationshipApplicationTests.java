package com.example.test_relationship;

import com.example.test_relationship.utils.PasswordUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class TestRelationshipApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(" PASSWORD : " + PasswordUtils.encrypt("123"));

    }

}

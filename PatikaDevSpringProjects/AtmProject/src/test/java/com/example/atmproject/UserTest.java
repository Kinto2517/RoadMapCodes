package com.example.atmproject;

import com.example.atmproject.model.User;
import com.example.atmproject.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testUpdateFailedAttempt() {

        String email = "ersin@ersin.com";
        int failed_attempt = 2;

        userRepository.updateFailedAttempt(failed_attempt, email);

        Long id = 1L;
        User user =entityManager.find(User.class, id);

        assertEquals(failed_attempt, user.getFailed_attempt());

    }
}

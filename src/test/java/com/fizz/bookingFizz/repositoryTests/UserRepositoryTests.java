package com.fizz.bookingFizz.repositoryTests;

import static org.assertj.core.api.Assertions.assertThat;
import com.fizz.bookingFizz.Domain.User;
import com.fizz.bookingFizz.Repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
    @Autowired
    private UserRepository repo;

    @Test
    public void testFindUserByEmail(){
        String email = "vellenore@gmail.com";
        User user = repo.findByEmail(email);
        assertThat(user).isNotNull();
    }
}
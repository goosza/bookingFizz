package com.fizz.bookingFizz;

import static org.assertj.core.api.Assertions.assertThat;
import com.fizz.bookingFizz.Domain.User;
import com.fizz.bookingFizz.Repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
    @Autowired
    private UserRepository repo;
    @Autowired
    private TestEntityManager entityManager;
    @Test
    public void testCreateUser(){
        User user = new User();
        user.setEmail("vellenore@gmail.com");
        user.setPassword("Gosha7911");
        user.setFirstname("Georgii");
        user.setLastName("Denisov");
        User savedUser = repo.save(user);
        User existUser = entityManager.find(User.class, savedUser.getId());
        assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
    }
    @Test
    public void testFindUserByEmail(){
        String email = "vellenore@gmail.com";
        User user = repo.findByEmail(email);
        assertThat(user).isNotNull();

    }
}
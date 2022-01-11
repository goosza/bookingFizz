package com.fizz.bookingFizz.serviceTests;

import com.fizz.bookingFizz.Domain.User;
import com.fizz.bookingFizz.Dto.UserRegistrationDto;
import com.fizz.bookingFizz.Repositories.RoleRepository;
import com.fizz.bookingFizz.Repositories.UserRepository;
import com.fizz.bookingFizz.business.services.UserService;
import com.fizz.bookingFizz.business.services.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;


import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class UserServiceTests {
    @Mock
    private UserRepository userRepository;
    @Mock
    private RoleRepository roleRepository;
    @Mock
    UserRegistrationDto registrationDto;
    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void initUseCase(){
        userService = new UserServiceImpl(userRepository);
    }
    @Test
    public void testSaveUser() {
        registrationDto =
                new UserRegistrationDto("Nikita", "Grebnyakov", "n_g@gmail.com", "Nikita123");
        User user1 = new User(registrationDto.getFirstName(), registrationDto.getLastName(),
                registrationDto.getEmail(),registrationDto.getPassword(),
                Arrays.asList(roleRepository.getById(1L)));
        when(userRepository.save(any(User.class))).thenReturn(user1);
        User savedUser = userService.save(registrationDto);
        Assert.isTrue(user1.equals(savedUser),"success");
    }
}

package com.fizz.bookingFizz.serviceTests;

import com.fizz.bookingFizz.Domain.User;
import com.fizz.bookingFizz.Dto.UserRegistrationDto;
import com.fizz.bookingFizz.Repositories.UserRepository;
import com.fizz.bookingFizz.business.services.UserServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {
    @Mock
    private UserRepository userRepository;

    @Autowired
    @InjectMocks
    private UserServiceImpl userService;
    private UserRegistrationDto userRegistrationDto;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @BeforeEach
    public void setUp(){
        userRegistrationDto = new UserRegistrationDto("Nikita", "Grebnyakov", "n_g@gmail.com",
                "Nikita1234");
    }
    @AfterEach
    public void tearDown(){
        userRegistrationDto = null;
    }
    @Test
    public void testSaveUser() {
        when(userRepository.save(any(User.class))).thenReturn(new User());
        User created = userService.save(userRegistrationDto);
        assertThat(created.getEmail()).isSameAs(userRegistrationDto.getEmail());
    }
}

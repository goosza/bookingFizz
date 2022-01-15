package com.fizz.bookingFizz.serviceTests;

import com.fizz.bookingFizz.domain.User;
import com.fizz.bookingFizz.pojo.UserRegistrationDto;
import com.fizz.bookingFizz.repositories.RoleRepository;
import com.fizz.bookingFizz.repositories.UserRepository;
import com.fizz.bookingFizz.business.services.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;


import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
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
    //@Test
//    public void testSaveUser() {
//        registrationDto =
//                new UserRegistrationDto("Nikita", "Grebnyakov", "n_g@gmail.com", "Nikita123");
//        User user1 = new User(registrationDto.getFirstName(), registrationDto.getLastName(),
//                registrationDto.getEmail(),registrationDto.getPassword(),
//                Arrays.asList(roleRepository.getById(1L)));
//        when(userRepository.save(any(User.class))).thenReturn(user1);
//        User savedUser = userService.save(registrationDto);
//        Assert.isTrue(user1.equals(savedUser),"success");
//    }
}

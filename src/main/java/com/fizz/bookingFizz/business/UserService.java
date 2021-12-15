package com.fizz.bookingFizz.business;

import com.fizz.bookingFizz.Domain.User;
import com.fizz.bookingFizz.Dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}

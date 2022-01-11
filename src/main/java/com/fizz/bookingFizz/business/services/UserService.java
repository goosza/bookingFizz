package com.fizz.bookingFizz.business.services;

import com.fizz.bookingFizz.Domain.User;
import com.fizz.bookingFizz.Dto.UserRegistrationDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
    //User getCurrentlyLoggedInUser(Authentication authentication);
}

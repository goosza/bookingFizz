package com.fizz.bookingFizz.business.services;

import com.fizz.bookingFizz.domain.User;
import com.fizz.bookingFizz.pojo.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
    //User getCurrentlyLoggedInUser(Authentication authentication);
}

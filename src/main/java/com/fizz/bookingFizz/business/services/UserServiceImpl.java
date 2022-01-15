package com.fizz.bookingFizz.business.services;

import com.fizz.bookingFizz.domain.User;
import com.fizz.bookingFizz.pojo.UserRegistrationDto;
import com.fizz.bookingFizz.repositories.RoleRepository;
import com.fizz.bookingFizz.repositories.UserRepository;
import com.fizz.bookingFizz.business.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserServiceImpl(){};

    @Override
    public User save(UserRegistrationDto registrationDto) {
        User user = new User(registrationDto.getFirstName(), registrationDto.getLastName(),
                registrationDto.getEmail(), passwordEncoder.encode(registrationDto.getPassword()),
                new HashSet<>(Arrays.asList(roleRepository.getById(1L))));
        userRepository.save(user);
        return user;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new CustomUserDetails(user);
    }
}

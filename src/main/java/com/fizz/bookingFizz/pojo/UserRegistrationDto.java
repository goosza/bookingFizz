package com.fizz.bookingFizz.pojo;

import com.fizz.bookingFizz.domain.User;
import com.fizz.bookingFizz.repositories.UserRepository;

public class UserRegistrationDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    private UserRepository userRepository;

    public UserRegistrationDto() {
    }

    public UserRegistrationDto(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return userRepository.findByEmail(email);
    }
}

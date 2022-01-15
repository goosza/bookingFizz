package com.fizz.bookingFizz.business;

import com.fizz.bookingFizz.domain.User;
import com.fizz.bookingFizz.domain.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class CustomUserDetails implements UserDetails {
    private User user;
    public CustomUserDetails(User user){
        this.user = user;
    }

    public CustomUserDetails() {

    }
    public User getUser(){
        return user;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<UserRole> roles = user.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (UserRole role: roles){
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

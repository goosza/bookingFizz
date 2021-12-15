package com.fizz.bookingFizz.Repositories;

import com.fizz.bookingFizz.Domain.User;
import com.fizz.bookingFizz.Domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<UserRole, Long> {

}

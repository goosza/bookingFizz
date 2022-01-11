package com.fizz.bookingFizz.Repositories;

import com.fizz.bookingFizz.Domain.SignedUpLocalEvent;
import com.fizz.bookingFizz.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SignedUpLocalEventRepository extends JpaRepository<SignedUpLocalEvent, Long> {
    public List<SignedUpLocalEvent> findByUser(User user);
}

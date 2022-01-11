package com.fizz.bookingFizz.repositories;

import com.fizz.bookingFizz.domain.SignedUpLocalEvent;
import com.fizz.bookingFizz.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SignedUpLocalEventRepository extends JpaRepository<SignedUpLocalEvent, Long> {
    public List<SignedUpLocalEvent> findByUser(User user);
}

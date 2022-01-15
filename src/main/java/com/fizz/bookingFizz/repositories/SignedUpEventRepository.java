package com.fizz.bookingFizz.repositories;

import com.fizz.bookingFizz.domain.LocalEvent;
import com.fizz.bookingFizz.domain.SignedUpEvent;
import com.fizz.bookingFizz.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SignedUpEventRepository extends JpaRepository<SignedUpEvent, Long> {
    public List<SignedUpEvent> findByUser(User user);
    public SignedUpEvent findByUserAndLocalEvent(User user, LocalEvent localEvent);
}

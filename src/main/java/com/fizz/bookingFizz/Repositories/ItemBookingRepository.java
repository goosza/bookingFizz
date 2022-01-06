package com.fizz.bookingFizz.Repositories;


import com.fizz.bookingFizz.Domain.ItemBooking;
import com.fizz.bookingFizz.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemBookingRepository extends JpaRepository<ItemBooking, Long> {
    public List<ItemBooking> findByUser(User user);
}

package com.fizz.bookingFizz.repositories;


import com.fizz.bookingFizz.domain.Item;
import com.fizz.bookingFizz.domain.ItemBooking;
import com.fizz.bookingFizz.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ItemBookingRepository extends JpaRepository<ItemBooking, Long> {
    public List<ItemBooking> findByUser(User user);
    public List<ItemBooking> findByItemAndDate(Item item, LocalDate date);
}

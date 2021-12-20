package com.fizz.bookingFizz.Repositories;

import com.fizz.bookingFizz.Domain.ItemBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemBookingRepository extends JpaRepository<ItemBooking, Long> {
}

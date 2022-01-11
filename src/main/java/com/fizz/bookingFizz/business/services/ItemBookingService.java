package com.fizz.bookingFizz.business.services;

import com.fizz.bookingFizz.domain.ItemBooking;
import com.fizz.bookingFizz.domain.User;

import java.util.List;

public interface ItemBookingService {
    ItemBooking saveItemBooking(ItemBooking itemBooking);
    List<ItemBooking> getAllItemBookings();
    List<ItemBooking> listItemBookings(User user);
    ItemBooking getItemBookingId(Long id);
    void deleteItemBooking(Long id);
}

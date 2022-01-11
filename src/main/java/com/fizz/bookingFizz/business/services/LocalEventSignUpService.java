package com.fizz.bookingFizz.business.services;

import com.fizz.bookingFizz.Domain.ItemBooking;
import com.fizz.bookingFizz.Domain.User;

import java.util.List;

public interface LocalEventSignUpService {
    ItemBooking saveItemBooking(ItemBooking itemBooking);
    List<ItemBooking> getAllItemBookings();
    List<ItemBooking> listItemBookings(User user);
    ItemBooking getItemBookingId(Long id);
    void deleteItemBooking(Long id);
}

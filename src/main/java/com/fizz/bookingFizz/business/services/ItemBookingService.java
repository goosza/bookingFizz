package com.fizz.bookingFizz.business.services;

import com.fizz.bookingFizz.Domain.Item;
import com.fizz.bookingFizz.Domain.ItemBooking;

import java.util.List;

public interface ItemBookingService {
    ItemBooking saveItemBooking(ItemBooking itemBooking);
    List<ItemBooking> getAllItemBookings();
    ItemBooking getItemBookingId(Long id);
    void deleteItemBooking(Long id);
}

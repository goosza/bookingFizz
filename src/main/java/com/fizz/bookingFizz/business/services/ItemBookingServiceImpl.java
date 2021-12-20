package com.fizz.bookingFizz.business.services;

import com.fizz.bookingFizz.Domain.Item;
import com.fizz.bookingFizz.Domain.ItemBooking;
import com.fizz.bookingFizz.Repositories.ItemBookingRepository;
import com.fizz.bookingFizz.Repositories.ItemRepository;
import com.fizz.bookingFizz.exception.ResourceNotFoundException;

import java.util.List;

public class ItemBookingServiceImpl implements ItemBookingService{
    private ItemBookingRepository itemBookingRepository;

    public ItemBookingServiceImpl(ItemBookingRepository itemBookingRepository) {
        this.itemBookingRepository = itemBookingRepository;
    }

    @Override
    public ItemBooking saveItemBooking(ItemBooking itemBooking) {
        return itemBookingRepository.save(itemBooking);
    }

    @Override
    public List<ItemBooking> getAllItemBookings() {
        return itemBookingRepository.findAll();
    }

    @Override
    public ItemBooking getItemBookingId(Long id) {
        return itemBookingRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("ItemBooking", "Id", id));
    }

    @Override
    public void deleteItemBooking(Long id) {
        ItemBooking foundItemBooking = this.getItemBookingId(id);
        itemBookingRepository.delete(foundItemBooking);
    }
}

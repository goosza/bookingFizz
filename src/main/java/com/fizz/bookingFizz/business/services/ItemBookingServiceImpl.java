package com.fizz.bookingFizz.business.services;

import com.fizz.bookingFizz.Domain.Item;
import com.fizz.bookingFizz.Domain.ItemBooking;
import com.fizz.bookingFizz.Domain.User;
import com.fizz.bookingFizz.Repositories.ItemBookingRepository;
import com.fizz.bookingFizz.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemBookingServiceImpl implements ItemBookingService{
    @Autowired
    private ItemBookingRepository itemBookingRepository;

    public ItemBookingServiceImpl(ItemBookingRepository itemBookingRepository) {
        this.itemBookingRepository = itemBookingRepository;
    }
    @Override
    public List<ItemBooking> listItemBookings(User user){
        return itemBookingRepository.findByUser(user);
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

package com.fizz.bookingFizz.business.services;

import com.fizz.bookingFizz.domain.Item;
import com.fizz.bookingFizz.domain.ItemBooking;
import com.fizz.bookingFizz.domain.User;
import com.fizz.bookingFizz.repositories.ItemBookingRepository;
import com.fizz.bookingFizz.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    public List<ItemBooking> findByItemAndDate(Item item, LocalDate date) {
        return itemBookingRepository.findByItemAndDate(item, date);
    }

    @Override
    public void deleteItemBooking(Long id) {
        ItemBooking foundItemBooking = this.getItemBookingId(id);
        itemBookingRepository.delete(foundItemBooking);
    }
}

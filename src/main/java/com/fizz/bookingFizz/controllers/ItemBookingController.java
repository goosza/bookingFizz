package com.fizz.bookingFizz.controllers;

import com.fizz.bookingFizz.domain.ItemBooking;
import com.fizz.bookingFizz.business.CustomUserDetails;
import com.fizz.bookingFizz.business.services.ItemBookingService;
import com.fizz.bookingFizz.business.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ItemBookingController {

    @Autowired
    private ItemBookingService itemBookingService;


    public ItemBookingController(ItemBookingService itemBookingService) {
        this.itemBookingService = itemBookingService;
    }


//    @PostMapping("/items/reservation")
//    public String addNewReservation(@RequestParam @RequestParam String name,
//                                    @RequestParam int quantity) throws IOException {
//
//    }
}

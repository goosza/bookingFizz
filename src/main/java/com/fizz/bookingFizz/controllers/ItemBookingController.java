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

import java.util.List;

@Controller
public class ItemBookingController {

    @Autowired
    private ItemBookingService itemBookingService;

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String showProfileBookings(Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<ItemBooking> listItemBookings = itemBookingService.listItemBookings(((CustomUserDetails)principal).getUser());
        model.addAttribute("itemBookings", listItemBookings);
        return "profile";
    }
//     @PostMapping("/items/reservation")
//    public String addNewReservation(@RequestParam  @RequestParam String name,
//                                    @RequestParam int quantity) throws IOException {
//
//    }
}

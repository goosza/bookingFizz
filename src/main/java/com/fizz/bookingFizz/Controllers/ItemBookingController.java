package com.fizz.bookingFizz.Controllers;

import com.fizz.bookingFizz.Domain.ItemBooking;
import com.fizz.bookingFizz.Domain.User;
import com.fizz.bookingFizz.business.services.ItemBookingService;
import com.fizz.bookingFizz.business.services.ItemService;
import com.fizz.bookingFizz.business.services.UserService;
import com.fizz.bookingFizz.business.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class ItemBookingController {

    @Autowired
    private ItemBookingService itemBookingService;

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String showProfileBookings(Model model, @AuthenticationPrincipal Authentication authentication){
        User user = userService.getCurrentlyLoggedInUser(authentication);
        List<ItemBooking> listItemBookings = itemBookingService.listItemBookings(user);
        model.addAttribute("itemBookings", listItemBookings);
        return "profile";
    }
//     @PostMapping("/items/reservation")
//    public String addNewReservation(@RequestParam  @RequestParam String name,
//                                    @RequestParam int quantity) throws IOException {
//
//    }
}

package com.fizz.bookingFizz.controllers;

import com.fizz.bookingFizz.business.CustomUserDetails;
import com.fizz.bookingFizz.business.services.ItemBookingService;
import com.fizz.bookingFizz.business.services.LocalEventService;
import com.fizz.bookingFizz.business.services.SignedUpEventService;
import com.fizz.bookingFizz.domain.ItemBooking;
import com.fizz.bookingFizz.domain.SignedUpEvent;
import com.fizz.bookingFizz.domain.User;
import com.fizz.bookingFizz.pojo.ProfileAttr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProfileController {
    @Autowired
    private SignedUpEventService signedUpEventService;

    @Autowired
    private ItemBookingService itemBookingService;

    public ProfileController(SignedUpEventService signedUpEventService, ItemBookingService itemBookingService) {
        this.signedUpEventService = signedUpEventService;
        this.itemBookingService = itemBookingService;
    }

    @GetMapping("/profile")
    public String showProfileEvents(Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = ((CustomUserDetails)principal).getUser();
        List<SignedUpEvent> listSignedUpEvents =
                signedUpEventService.listSignedUpLocalEvents(user);
        List<ItemBooking> listItemBookings =
                itemBookingService.listItemBookings(user);
        ProfileAttr profileAttr = new ProfileAttr();
        profileAttr.setListSignedUpEvents(listSignedUpEvents);
        profileAttr.setListItemBookings(listItemBookings);
        model.addAttribute("profileAttr", profileAttr);
        return "profile";
    }
}

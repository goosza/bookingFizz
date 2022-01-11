package com.fizz.bookingFizz.controllers;

import com.fizz.bookingFizz.domain.SignedUpLocalEvent;
import com.fizz.bookingFizz.business.CustomUserDetails;
import com.fizz.bookingFizz.business.services.LocalEventSignUpService;
import com.fizz.bookingFizz.business.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SignedUpLocalEventsController {
    @Autowired
    private LocalEventSignUpService localEventSignUpService;

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String showProfileBookings(Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<SignedUpLocalEvent> listSignedUpLocalEvents =
                localEventSignUpService.listSignedUpLocalEvents(((CustomUserDetails)principal).getUser());
        model.addAttribute("listSignedUpLocalEvents", listSignedUpLocalEvents);
        return "profile";
    }
}

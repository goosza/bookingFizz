package com.fizz.bookingFizz.controllers;

import com.fizz.bookingFizz.business.services.LocalEventService;
import com.fizz.bookingFizz.domain.LocalEvent;
import com.fizz.bookingFizz.domain.SignedUpEvent;
import com.fizz.bookingFizz.business.CustomUserDetails;
import com.fizz.bookingFizz.business.services.SignedUpEventService;
import com.fizz.bookingFizz.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SignedUpEventsController {
    @Autowired
    private SignedUpEventService signedUpEventService;

    @Autowired
    private LocalEventService localEventService;

    public SignedUpEventsController(SignedUpEventService signedUpEventService, LocalEventService localEventService) {
        this.signedUpEventService = signedUpEventService;
        this.localEventService = localEventService;
    }


    @PostMapping("/localevents/{leId}/signingup")
    public String signUpForEvent( @PathVariable("leId") Long event_id){
//
//        if (authentication == null || authentication instanceof AnonymousAuthenticationToken)
//            return "You must login to sign up fot this event";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = ((CustomUserDetails)principal).getUser();
        LocalEvent localEvent = localEventService.getLocalEventId(event_id);
        if (signedUpEventService.findByUserAndLocalEvent(user, localEvent) != null){
            return "You have already signed up for this event";
        }
        SignedUpEvent signedUpEvent = new SignedUpEvent(localEvent, user);
        signedUpEventService.saveSignedUpLocalEvent(signedUpEvent);
        return "redirect:/localevents";
    }
}

package com.fizz.bookingFizz.business.services;

import com.fizz.bookingFizz.Domain.ItemBooking;
import com.fizz.bookingFizz.Domain.SignedUpLocalEvent;
import com.fizz.bookingFizz.Domain.User;

import java.util.List;

public interface LocalEventSignUpService {
    SignedUpLocalEvent saveSignedUpLocalEvent(SignedUpLocalEvent signedUpLocalEvent);
    List<SignedUpLocalEvent> getAllSignedUpLocalEvents();
    List<SignedUpLocalEvent> listSignedUpLocalEvents(User user);
    SignedUpLocalEvent getSignedUpLocalEventId(Long id);
    void deleteSignedUpLocalEvent(Long id);
}

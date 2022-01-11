package com.fizz.bookingFizz.business.services;

import com.fizz.bookingFizz.domain.SignedUpLocalEvent;
import com.fizz.bookingFizz.domain.User;

import java.util.List;

public interface LocalEventSignUpService {
    SignedUpLocalEvent saveSignedUpLocalEvent(SignedUpLocalEvent signedUpLocalEvent);
    List<SignedUpLocalEvent> getAllSignedUpLocalEvents();
    List<SignedUpLocalEvent> listSignedUpLocalEvents(User user);
    SignedUpLocalEvent getSignedUpLocalEventId(Long id);
    void deleteSignedUpLocalEvent(Long id);
}

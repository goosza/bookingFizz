package com.fizz.bookingFizz.business.services;

import com.fizz.bookingFizz.domain.LocalEvent;
import com.fizz.bookingFizz.domain.SignedUpEvent;
import com.fizz.bookingFizz.domain.User;

import java.util.List;

public interface SignedUpEventService {
    SignedUpEvent saveSignedUpLocalEvent(SignedUpEvent signedUpEvent);
    List<SignedUpEvent> getAllSignedUpLocalEvents();
    List<SignedUpEvent> listSignedUpLocalEvents(User user);
    SignedUpEvent findByUserAndLocalEvent(User user, LocalEvent localEvent);
    SignedUpEvent getSignedUpLocalEventId(Long id);
    void deleteSignedUpLocalEvent(Long id);
}

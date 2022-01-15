package com.fizz.bookingFizz.pojo;

import com.fizz.bookingFizz.domain.ItemBooking;
import com.fizz.bookingFizz.domain.SignedUpEvent;

import java.util.List;

public class ProfileAttr {
    List<SignedUpEvent> listSignedUpEvents;
    List<ItemBooking> listItemBookings;

    public ProfileAttr() {

    }

    public List<SignedUpEvent> getListSignedUpEvents() {
        return listSignedUpEvents;
    }

    public void setListSignedUpEvents(List<SignedUpEvent> listSignedUpEvents) {
        this.listSignedUpEvents = listSignedUpEvents;
    }

    public List<ItemBooking> getListItemBookings() {
        return listItemBookings;
    }

    public void setListItemBookings(List<ItemBooking> listItemBookings) {
        this.listItemBookings = listItemBookings;
    }
}

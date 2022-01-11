package com.fizz.bookingFizz.business.services;

import com.fizz.bookingFizz.domain.LocalEvent;

import java.time.LocalDateTime;
import java.util.List;

public interface LocalEventService {
    LocalEvent saveLocalEvent(LocalEvent localEvent);
    List<LocalEvent> getAllLocalEvents();
    LocalEvent getLocalEventId(Long id);
    LocalEvent updateItem(Long id, String name, String description, LocalDateTime timefrom, LocalDateTime timeto, int capacity);
    void deleteEvent(Long id);
}

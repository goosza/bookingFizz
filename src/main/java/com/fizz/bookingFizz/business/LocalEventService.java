package com.fizz.bookingFizz.business;

import com.fizz.bookingFizz.Domain.Item;
import com.fizz.bookingFizz.Domain.LocalEvent;

import java.time.LocalDateTime;
import java.util.List;

public interface LocalEventService {
    LocalEvent saveLocalEvent(LocalEvent localEvent);
    List<LocalEvent> getAllLocalEvents();
    LocalEvent getLocalEventId(Long id);
    LocalEvent updateItem(Long id, String name, String description, LocalDateTime timefrom, LocalDateTime timeto);
    void deleteEvent(Long id);
}

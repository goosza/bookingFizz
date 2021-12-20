package com.fizz.bookingFizz.business.services;

import com.fizz.bookingFizz.Domain.LocalEvent;
import com.fizz.bookingFizz.Repositories.LocalEventRepository;
import com.fizz.bookingFizz.business.services.LocalEventService;
import com.fizz.bookingFizz.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LocalEventServiceImpl implements LocalEventService {
    private LocalEventRepository localEventRepository;
    public LocalEventServiceImpl(LocalEventRepository localEventRepository) {
        this.localEventRepository = localEventRepository;
    }

    @Override
    public LocalEvent saveLocalEvent(LocalEvent localEvent) {
        return localEventRepository.save(localEvent);
    }

    @Override
    public List<LocalEvent> getAllLocalEvents() {
        return localEventRepository.findAll();
    }

    @Override
    public LocalEvent getLocalEventId(Long id) {
        return localEventRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Item", "Id", id));
    }

    @Override
    public LocalEvent updateItem(Long id, String name, String description, LocalDateTime datefrom, LocalDateTime dateto) {
        LocalEvent existingEvent = localEventRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Item", "Id", id));
        existingEvent.setName(name);
        existingEvent.setDescription(description);
        existingEvent.setDatefrom(datefrom);
        existingEvent.setDateto(dateto);
        localEventRepository.save(existingEvent);
        return existingEvent;
    }
    @Override
    public void deleteEvent(Long id) {
        LocalEvent foundEvent = this.getLocalEventId(id);
        localEventRepository.delete(foundEvent);
    }
}

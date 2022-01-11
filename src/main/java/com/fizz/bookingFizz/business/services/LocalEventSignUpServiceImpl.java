package com.fizz.bookingFizz.business.services;

import com.fizz.bookingFizz.domain.SignedUpLocalEvent;
import com.fizz.bookingFizz.domain.User;
import com.fizz.bookingFizz.repositories.SignedUpLocalEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalEventSignUpServiceImpl implements LocalEventSignUpService{
    @Autowired
    private SignedUpLocalEventRepository signedUpLocalEventRepository;

    public LocalEventSignUpServiceImpl(SignedUpLocalEventRepository signedUpLocalEventRepository) {
        this.signedUpLocalEventRepository = signedUpLocalEventRepository;
    }

    @Override
    public SignedUpLocalEvent saveSignedUpLocalEvent(SignedUpLocalEvent signedUpLocalEvent) {
        return signedUpLocalEventRepository.save(signedUpLocalEvent);
    }

    @Override
    public List<SignedUpLocalEvent> getAllSignedUpLocalEvents() {
        return signedUpLocalEventRepository.findAll();
    }

    @Override
    public List<SignedUpLocalEvent> listSignedUpLocalEvents(User user) {
        return signedUpLocalEventRepository.findByUser(user);
    }

    @Override
    public SignedUpLocalEvent getSignedUpLocalEventId(Long id) {
        return signedUpLocalEventRepository.getById(id);
    }

    @Override
    public void deleteSignedUpLocalEvent(Long id) {
        signedUpLocalEventRepository.deleteById(id);
    }
}

package com.fizz.bookingFizz.business.services;

import com.fizz.bookingFizz.domain.LocalEvent;
import com.fizz.bookingFizz.domain.SignedUpEvent;
import com.fizz.bookingFizz.domain.User;
import com.fizz.bookingFizz.repositories.SignedUpEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignedUpEventServiceImpl implements SignedUpEventService {
    @Autowired
    private SignedUpEventRepository signedUpEventRepository;

    public SignedUpEventServiceImpl(SignedUpEventRepository signedUpEventRepository) {
        this.signedUpEventRepository = signedUpEventRepository;
    }

    @Override
    public SignedUpEvent saveSignedUpLocalEvent(SignedUpEvent signedUpEvent) {
        return signedUpEventRepository.save(signedUpEvent);
    }


    @Override
    public List<SignedUpEvent> listSignedUpLocalEvents(User user) {
        return signedUpEventRepository.findByUser(user);
    }

    @Override
    public SignedUpEvent findByUserAndLocalEvent(User user, LocalEvent localEvent) {
        return signedUpEventRepository.findByUserAndLocalEvent(user, localEvent);
    }

    @Override
    public void deleteSignedUpLocalEvent(Long id) {
        signedUpEventRepository.deleteById(id);
    }
}

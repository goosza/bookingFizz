package com.fizz.bookingFizz.repositories;

import com.fizz.bookingFizz.domain.LocalEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalEventRepository extends JpaRepository<LocalEvent, Long> {

}

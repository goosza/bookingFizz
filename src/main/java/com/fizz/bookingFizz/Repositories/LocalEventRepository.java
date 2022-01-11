package com.fizz.bookingFizz.Repositories;

import com.fizz.bookingFizz.Domain.LocalEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalEventRepository extends JpaRepository<LocalEvent, Long> {

}

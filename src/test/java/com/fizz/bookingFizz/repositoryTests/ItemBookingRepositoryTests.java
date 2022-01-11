package com.fizz.bookingFizz.repositoryTests;

import static org.assertj.core.api.Assertions.assertThat;
import com.fizz.bookingFizz.Domain.ItemBooking;
import com.fizz.bookingFizz.Domain.User;
import com.fizz.bookingFizz.Repositories.ItemBookingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ItemBookingRepositoryTests {
    @Autowired
    private ItemBookingRepository repo;
//    @Autowired
//    private TestEntityManager entityManager;
//    @Test
//    public void testAddOne(){
//        Integer i = 47;
//        Long l = Long.valueOf(i);
//        Integer i2 = 18;
//        Long l2 = Long.valueOf(i2);
//        Item item = entityManager.find(Item.class, l);
//        User user = entityManager.find(User.class, l2);
//        ItemBooking itemBooking = new ItemBooking();
//        itemBooking.setUser(user);
//        itemBooking.setItem(item);
//        LocalDateTime localDateTime1 =
//                LocalDateTime.of(2022, Month.MARCH, 28, 14, 33, 48);
//        LocalDateTime localDateTime2 =
//                LocalDateTime.of(2022, Month.MARCH, 29, 14, 33, 48);
//        itemBooking.setValidFrom(localDateTime1);
//        itemBooking.setValidTo(localDateTime2);
//        ItemBooking savedItemBooking = repo.save(itemBooking);
//        ItemBooking existItemBooking = entityManager.find(ItemBooking.class, savedItemBooking.getId());
//        assertThat(existItemBooking.getId()).isEqualTo(itemBooking.getId());
//    }
    @Test
    public void TestGetItemBookingByUser(){
        User user = new User();
        user.setId(18L);
        List<ItemBooking> itemBookings = repo.findByUser(user);
        assertThat(itemBookings.size()).isEqualTo(2);
    }
}

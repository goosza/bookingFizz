package com.fizz.bookingFizz.controllers;

import com.fizz.bookingFizz.business.services.ItemService;
import com.fizz.bookingFizz.domain.Item;
import com.fizz.bookingFizz.domain.ItemBooking;
import com.fizz.bookingFizz.business.CustomUserDetails;
import com.fizz.bookingFizz.business.services.ItemBookingService;
import com.fizz.bookingFizz.domain.User;
import com.fizz.bookingFizz.pojo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ItemBookingController {

    @Autowired
    private ItemBookingService itemBookingService;

    @Autowired
    private ItemService itemService;

    public ItemBookingController(ItemBookingService itemBookingService) {
        this.itemBookingService = itemBookingService;
    }
    @RequestMapping("/items/analyzing")
    public void itemAvailability(@RequestParam("item_id") Long item_id,
                                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate, Model model){
        AjaxResponse response = new AjaxResponse();
        Item item = itemService.getItemId(item_id);
        List<ItemBooking> itemBookings = itemBookingService.findByItemAndDate(item, localDate);
        if (itemBookings == null)
            response.setMsg("It's not possible to make a reservation this day");
        else
            response.setMsg("Item is available");
        model.addAttribute("message", response);

    }
    @PostMapping("/items/{itemId}/reservation")
    public String addNewReservation(@PathVariable("itemId") Long item_id,
                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = ((CustomUserDetails)principal).getUser();
        Item item = itemService.getItemId(item_id);
        // here ll be added extra logic not to let same user book one item a few times in some period of time
        ItemBooking itemBooking = new ItemBooking(item, user, date);
        itemBookingService.saveItemBooking(itemBooking);
        return "redirect:/items";
    }
}

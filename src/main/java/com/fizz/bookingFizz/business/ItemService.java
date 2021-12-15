package com.fizz.bookingFizz.business;

import com.fizz.bookingFizz.Domain.Item;

import java.util.List;

public interface ItemService {
    Item saveItem(Item item);
    List<Item> getAllItems();
    Item getItemId(Long id);
    Item updateItem(Long id, String name, int quantity);
    void deleteItem(Long id);
}

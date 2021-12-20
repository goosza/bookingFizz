package com.fizz.bookingFizz.business.services;

import com.fizz.bookingFizz.Domain.Item;
import com.fizz.bookingFizz.Repositories.ItemRepository;
import com.fizz.bookingFizz.business.services.ItemService;
import com.fizz.bookingFizz.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    private ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemId(Long id) {
        return itemRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Item", "Id", id));
    }
    @Override
    public Item updateItem(Long id, String name, int quantity) {
        Item existingItem = itemRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Item", "Id", id));
        existingItem.setName(name);
        existingItem.setQuantity(quantity);
        itemRepository.save(existingItem);
        return existingItem;
    }

    @Override
    public void deleteItem(Long id) {
        Item foundItem = this.getItemId(id);
        itemRepository.delete(foundItem);
    }
}

package com.task.inventory.service;

import com.task.inventory.exception.ItemNotFoundException;
import com.task.inventory.model.Item;
import com.task.inventory.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElseThrow(()->new ItemNotFoundException("Item not found with id :"+ id));
    }

    @Override
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void deleteItem(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(()-> new ItemNotFoundException("Item not found"));
        itemRepository.delete(item);
    }

    @Override
    public Item updateItem(Long id, Item updatedItem) {
        Item item = getItemById(id);
        item.setName(updatedItem.getName());
        item.setPrice(updatedItem.getPrice());
        item.setQuantity(updatedItem.getQuantity());
        return itemRepository.save(item);
    }
}

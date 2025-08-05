package com.task.inventory.service;

import com.task.inventory.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {

    List<Item> getAllItems();

    Item getItemById(Long id);

    Item createItem(Item item);

    void deleteItem(Long id);


    Item updateItem(Long id, Item updatedItem);
}

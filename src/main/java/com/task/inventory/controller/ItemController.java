package com.task.inventory.controller;

import com.task.inventory.model.Item;
import com.task.inventory.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }


    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item){
        Item items = itemService.createItem(item);
        return new ResponseEntity<>(items, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Item>> getAllItem(){
        List<Item> items = itemService.getAllItems();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id){
        Item items = itemService.getItemById(id);
        return ResponseEntity.ok(items);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id,@RequestBody Item updatedItem){
        return ResponseEntity.ok(itemService.updateItem(id,updatedItem));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id){
        itemService.deleteItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}

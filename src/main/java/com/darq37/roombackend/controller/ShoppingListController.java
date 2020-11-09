package com.darq37.roombackend.controller;

import com.darq37.roombackend.domain.ShoppingList;
import com.darq37.roombackend.service.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class ShoppingListController {
    private final ShoppingListService service;

    @Autowired
    public ShoppingListController(ShoppingListService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ShoppingList> getLists() {
        System.out.println("Shopping lists synced");
        return service.getShoppingLists();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<ShoppingList> getList(@PathVariable Long id) {
        return service.getShoppingList(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ShoppingList saveList(@RequestBody ShoppingList shoppingList) {
        return service.saveList(shoppingList);
    }

}

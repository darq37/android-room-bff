package com.darq37.roombackend.service;

import com.darq37.roombackend.domain.ShoppingList;
import com.darq37.roombackend.repository.ShoppingListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingListService {

    private final ShoppingListRepository shoppingListRepository;

    public ShoppingListService(ShoppingListRepository shoppingListRepository) {
        this.shoppingListRepository = shoppingListRepository;
    }

    public List<ShoppingList> getShoppingLists(){
        return shoppingListRepository.findAll();
    }

    public Optional<ShoppingList> getShoppingList(Long id){
        return shoppingListRepository.findById(id);
    }

}

package com.darq37.roombackend;

import com.darq37.roombackend.domain.Product;
import com.darq37.roombackend.domain.ShoppingList;
import com.darq37.roombackend.domain.User;
import com.darq37.roombackend.service.ProductService;
import com.darq37.roombackend.service.ShoppingListService;
import com.darq37.roombackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppRunner implements ApplicationRunner {
    private UserService userService;
    private ShoppingListService shoppingListService;
    private ProductService productService;

    @Autowired
    public AppRunner(UserService userService, ShoppingListService shoppingListService, ProductService productService) {
        this.userService = userService;
        this.shoppingListService = shoppingListService;
        this.productService = productService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = new User("login", "password", "Dominik");
        Product p1 = new Product("duck", "rubber duck");
        Product p2 = new Product("orange", "delicious orange");
        Product p3 = new Product("wood", "a plank of wood");

        List<Product> productList = new ArrayList<>();
        productList.add(p1);
        productList.add(p2);
        productList.add(p3);

        ShoppingList list = new ShoppingList("Lista Dominika", user, productList);

        userService.saveUser(user);
        productService.saveAll(productList);
        shoppingListService.saveList(list);

    }
}

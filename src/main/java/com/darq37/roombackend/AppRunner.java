package com.darq37.roombackend;

import com.darq37.roombackend.domain.Product;
import com.darq37.roombackend.domain.SharedList;
import com.darq37.roombackend.domain.ShoppingList;
import com.darq37.roombackend.domain.User;
import com.darq37.roombackend.service.ProductService;
import com.darq37.roombackend.service.SharedListService;
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
    private SharedListService sharedListService;

    @Autowired
    public AppRunner(UserService userService, ShoppingListService shoppingListService, ProductService productService, SharedListService sharedListService) {
        this.userService = userService;
        this.shoppingListService = shoppingListService;
        this.productService = productService;
        this.sharedListService = sharedListService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = new User("login", "password", "Dominik");
        User test = new User("test", "testpw", "Tester");
        Product p1 = new Product("duck", "rubber duck");
        Product p2 = new Product("orange", "delicious orange");
        Product p3 = new Product("wood", "a plank of wood");
        List<Product> productList = new ArrayList<>();
        List<Product> testList = new ArrayList<>();
        testList.add(p2);
        testList.add(p3);
        productList.add(p1);
        productList.add(p2);
        productList.add(p3);

        ShoppingList userList = new ShoppingList("Lista Dominika", user, productList);
        ShoppingList testerList = new ShoppingList("Lista Testera", test, testList);


        SharedList sharedList = new SharedList();
        sharedList.setOwner(user);
        sharedList.setShoppingList(testerList);

        userService.saveUser(user);
        userService.saveUser(test);
        productService.saveAll(productList);
        productService.saveAll(testList);
        shoppingListService.saveList(userList);
        shoppingListService.saveList(testerList);
        sharedListService.saveSharedList(sharedList);

    }
}

package com.darq37.roombackend.controller;

import com.darq37.roombackend.domain.User;
import com.darq37.roombackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers() {
        System.out.println("Users retrieved.");
        return userService.getUsers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{login}")
    public ResponseEntity<User> getUser(@PathVariable String login) {
        System.out.println(String.format("User with login: '%s' retrieved.", login));
        return userService.getUser(login)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(method = RequestMethod.POST)
    public User saveUser(@RequestBody User user) {
        System.out.println("User created.");
        return userService.saveUser(user);
    }

    @RequestMapping(method = RequestMethod.POST)
    public List<User> saveAll(@RequestBody List<User> users) {
        System.out.println("Users saved.");
        return userService.saveAll(users);
    }


}

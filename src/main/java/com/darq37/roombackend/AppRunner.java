package com.darq37.roombackend;

import com.darq37.roombackend.domain.User;
import com.darq37.roombackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class AppRunner implements ApplicationRunner {
    private UserService userService;

    @Autowired
    public AppRunner(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = new User();
        user.setLogin("login");
        user.setPassword("password");
        user.setDisplayName("Dominik");
        user.setCreated(new Date());
        user.setEdited(new Date());
        userService.saveUser(user);
    }
}

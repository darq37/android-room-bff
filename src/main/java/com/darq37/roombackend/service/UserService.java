package com.darq37.roombackend.service;

import com.darq37.roombackend.domain.User;
import com.darq37.roombackend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUser(String login){
        return userRepository.findById(login);
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

}

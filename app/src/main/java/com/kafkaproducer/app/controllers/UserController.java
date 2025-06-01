package com.kafkaproducer.app.controllers;

import com.kafkaproducer.app.models.User;
import com.kafkaproducer.app.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService service;
    public UserController(UserService service) {
        this.service = service;
    }
    
    @PostMapping("/user")
    public User generateDummyData() {
        return service.generateDummyData();
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return service.getUsers();
    }

    @GetMapping("/user/{key}")
    public User getUser(@PathVariable Long key) {
        return service.getUser(key);
    }
    
}

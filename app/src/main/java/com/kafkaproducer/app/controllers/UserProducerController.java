package com.kafkaproducer.app.controllers;

import com.kafkaproducer.app.common.AppConstants;
import com.kafkaproducer.app.services.UserProducerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserProducerController {

    private final UserProducerService service;
    public UserProducerController(UserProducerService service) {
        this.service = service;
    }
    
    @PostMapping("/publish/user/{key}")
    public ResponseEntity<String> publishDataToTopic(@PathVariable Long key) {
        service.publish(key);
        return new ResponseEntity<String>("message has been published to topic: "+ AppConstants.USERS_TOPIC, HttpStatus.OK);
    }
    
}

package com.kafkaproducer.app.services;

import com.kafkaproducer.app.common.AppConstants;
import com.kafkaproducer.app.models.User;
import com.kafkaproducer.app.repos.UserRepo;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserProducerService {
    
    private final KafkaTemplate<String, User> kafkaTemplate;
    private final UserRepo repo;

    public UserProducerService(KafkaTemplate<String, User> kafkaTemplate, UserRepo repo) {
        this.kafkaTemplate = kafkaTemplate;
        this.repo = repo;
    }

    public void publish(Long key) {
            User user = repo.findByKey(key);
            kafkaTemplate.send(AppConstants.USERS_TOPIC, String.valueOf(user.getKey()), user);
    }
}

package com.kafkaproducer.app.services;

import com.kafkaproducer.app.common.AppConstants;
import com.kafkaproducer.app.models.OutboxUserEvent;
import com.kafkaproducer.app.models.User;
import com.kafkaproducer.app.repos.OutboxUserEventRepo;
import com.kafkaproducer.app.repos.UserRepo;
import jakarta.transaction.Transactional;
import net.datafaker.Faker;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class UserService {
    
    private final Faker faker;
    private final UserRepo userRepo;
    private final OutboxUserEventRepo userEventRepo;
    public UserService(Faker faker, UserRepo repo, OutboxUserEventRepo userEventRepo) {
        this.faker = faker;
        this.userRepo = repo;
        this.userEventRepo = userEventRepo;
    }

    @Transactional
    public User generateDummyData() {
        String name = faker.name().fullName();
        String address = faker.address().fullAddress();
        User user = new User(name, address);
        User createdUserInstance = userRepo.save(user);
        
        String payload = createdUserInstance.toJson();
        userEventRepo.save(new OutboxUserEvent(
                user.getClass().getSimpleName(),
                user.getKey(),
                AppConstants.USER_CREATED,
                payload,
                Instant.now()
        ));
        
        return createdUserInstance;
    }
    
    public List<User> getUsers()
    {
        return userRepo.findAll();
    }
    
    public User getUser(Long id)
    {
        return userRepo.findByKey(id);
    }
    
}

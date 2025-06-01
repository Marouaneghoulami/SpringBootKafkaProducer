package com.kafkaproducer.app.repos;

import com.kafkaproducer.app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByKey(Long id);
}


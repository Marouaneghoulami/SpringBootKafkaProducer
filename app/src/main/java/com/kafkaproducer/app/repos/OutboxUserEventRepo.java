package com.kafkaproducer.app.repos;

import com.kafkaproducer.app.models.OutboxUserEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutboxUserEventRepo extends JpaRepository<OutboxUserEvent, Long> {
}


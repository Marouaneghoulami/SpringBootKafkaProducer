package com.kafkaproducer.app.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.Instant;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "outbox_userevent")
public class OutboxUserEvent {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long key;
    private String aggregateType;
    private Long aggregateId;
    private String eventType;
    @Column(columnDefinition = "TEXT")
    private String payload;
    @Column(nullable=false, updatable=false)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Instant createdAt;

    public OutboxUserEvent() {
    }

    public OutboxUserEvent(String aggregateType, Long aggregateId, String eventType, String payload, Instant createdAt) {
        this.aggregateType = aggregateType;
        this.aggregateId = aggregateId;
        this.eventType = eventType;
        this.payload = payload;
        this.createdAt = createdAt;
    }

    public Long getKey() {
        return key;
    }
    
    public String getAggregateType() {
        return aggregateType;
    }

    public void setAggregateType(String aggregateType) {
        this.aggregateType = aggregateType;
    }

    public Long getAggregateId() {
        return aggregateId;
    }

    public void setAggregateId(Long aggregateId) {
        this.aggregateId = aggregateId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
    
}


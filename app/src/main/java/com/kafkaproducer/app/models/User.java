package com.kafkaproducer.app.models;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long key;
    private String name;
    private String address;

    public User() {}
    
    public User(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Long getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toJson() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (Exception e) {
            throw new RuntimeException("Failed to serialize payload", e);
        }
    }

}

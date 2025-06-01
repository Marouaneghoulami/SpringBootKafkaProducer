package com.kafkaproducer.app.common;

public final class AppConstants {
    private AppConstants() { /* prevent instantiation */ }

    public static final String USERS_TOPIC   = "users";
    public static final String USERS_GROUP_ID    = "my-app-group";
    public static final Integer USERS_TOPIC_PART    = 3;
    public static final Integer USERS_TOPIC_REPLICAS    = 1;
    public static final String USER_CREATED = "USER_CREATED";
    
}


package com.kafkaproducer.app.configs;

import com.kafkaproducer.app.common.AppConstants;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic usersTopic() {
        return TopicBuilder.name(AppConstants.USERS_TOPIC)
                .partitions(AppConstants.USERS_TOPIC_PART)
                .replicas(AppConstants.USERS_TOPIC_REPLICAS)
                .build();
    }
}

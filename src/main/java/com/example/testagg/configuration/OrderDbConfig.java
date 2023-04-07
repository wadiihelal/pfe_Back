package com.example.testagg.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.example.testagg.repo.orderRepo"},
        mongoTemplateRef = OrderDbConfig.MONGO_TEMPLATE
)
public class OrderDbConfig {
    protected static final String MONGO_TEMPLATE = "newdb1MongoTemplate";
}
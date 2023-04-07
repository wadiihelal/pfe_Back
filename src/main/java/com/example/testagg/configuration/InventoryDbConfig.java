package com.example.testagg.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.example.testagg.repo.inventory"},
        mongoTemplateRef = InventoryDbConfig.MONGO_TEMPLATE
)
public class InventoryDbConfig {
    protected static final String MONGO_TEMPLATE = "newdb3MongoTemplate";
}
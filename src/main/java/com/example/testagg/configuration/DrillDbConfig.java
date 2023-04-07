package com.example.testagg.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.example.testagg.repo.stations.drill"},
        mongoTemplateRef = DrillDbConfig.MONGO_TEMPLATE
)
public class DrillDbConfig {
    protected static final String MONGO_TEMPLATE = "newdb15MongoTemplate";
}
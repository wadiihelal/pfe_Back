package com.example.testagg.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.example.testagg.repo.stations.press"},
        mongoTemplateRef = PressDbConfig.MONGO_TEMPLATE
)
public class PressDbConfig {
    protected static final String MONGO_TEMPLATE = "newdb17MongoTemplate";
}
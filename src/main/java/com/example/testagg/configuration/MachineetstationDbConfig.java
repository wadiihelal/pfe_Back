package com.example.testagg.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.example.testagg.repo.machineRepo"},
        mongoTemplateRef = MachineetstationDbConfig.MONGO_TEMPLATE
)
public class MachineetstationDbConfig {
    protected static final String MONGO_TEMPLATE = "newdb2MongoTemplate";
}
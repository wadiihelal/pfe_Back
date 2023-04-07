package com.example.testagg.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.example.testagg.repo.stations.hunkeler"},
        mongoTemplateRef = HunkelerDbConfig.MONGO_TEMPLATE
)
public class HunkelerDbConfig {
    protected static final String MONGO_TEMPLATE = "newdb15MongoTemplate";
}
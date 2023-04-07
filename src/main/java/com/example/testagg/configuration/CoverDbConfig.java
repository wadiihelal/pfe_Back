package com.example.testagg.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.example.testagg.repo.stations.cover"},
        mongoTemplateRef = CoverDbConfig.MONGO_TEMPLATE
)
public class CoverDbConfig {
    protected static final String MONGO_TEMPLATE = "newdb9MongoTemplate";
}
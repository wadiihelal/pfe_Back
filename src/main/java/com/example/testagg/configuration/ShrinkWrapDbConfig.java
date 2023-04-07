package com.example.testagg.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.example.testagg.repo.stations.shrinkWrap"},
        mongoTemplateRef = ShrinkWrapDbConfig.MONGO_TEMPLATE
)
public class ShrinkWrapDbConfig {
    protected static final String MONGO_TEMPLATE = "newdb18MongoTemplate";
}
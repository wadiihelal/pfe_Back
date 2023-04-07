package com.example.testagg.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@Configuration
@EnableMongoRepositories(basePackages = {"com.example.testagg.repo.stations.horizon"},
        mongoTemplateRef = HorizonDbConfig.MONGO_TEMPLATE
)
public class HorizonDbConfig {
    protected static final String MONGO_TEMPLATE = "newdb14MongoTemplate";
}
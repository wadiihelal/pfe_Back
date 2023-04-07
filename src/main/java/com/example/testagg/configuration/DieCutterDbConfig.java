package com.example.testagg.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.example.testagg.repo.stations.dieCutter"},
        mongoTemplateRef = DieCutterDbConfig.MONGO_TEMPLATE
)
public class DieCutterDbConfig {
    protected static final String MONGO_TEMPLATE = "newdb11MongoTemplate";
}
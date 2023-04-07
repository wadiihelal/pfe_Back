package com.example.testagg.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.example.testagg.repo.stations.cutter"},
        mongoTemplateRef = CutterDbConfig.MONGO_TEMPLATE
)
public class CutterDbConfig {
    protected static final String MONGO_TEMPLATE = "newdb10MongoTemplate";
}
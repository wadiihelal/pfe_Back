package com.example.testagg.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
@Configuration
@EnableMongoRepositories(basePackages = {"com.example.testagg.repo.stations.caseMaker"},
        mongoTemplateRef = CaseMakerDbConfig.MONGO_TEMPLATE
)
public class CaseMakerDbConfig {
    protected static final String MONGO_TEMPLATE = "newdb7MongoTemplate";
}
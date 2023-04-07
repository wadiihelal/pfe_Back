package com.example.testagg.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@Configuration
@EnableMongoRepositories(basePackages = {"com.example.testagg.repo.stations.caseBinder"},
        mongoTemplateRef = CaseBinderDbConfig.MONGO_TEMPLATE
)
public class CaseBinderDbConfig {
    protected static final String MONGO_TEMPLATE = "newdb6MongoTemplate";
}
package com.example.testagg.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@Configuration
@EnableMongoRepositories(basePackages = {"com.example.testagg.repo.stations.binder"},
        mongoTemplateRef = BinderDbConfig.MONGO_TEMPLATE
)
public class BinderDbConfig {
    protected static final String MONGO_TEMPLATE = "newdb4MongoTemplate";
}
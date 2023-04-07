package com.example.testagg.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@Configuration
@EnableMongoRepositories(basePackages = {"com.example.testagg.repo.stations.lamination"},
        mongoTemplateRef = LaminationDbConfig.MONGO_TEMPLATE
)
public class LaminationDbConfig {
    protected static final String MONGO_TEMPLATE = "newdb16MongoTemplate";
}
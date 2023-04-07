package com.example.testagg.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@Configuration
@EnableMongoRepositories(basePackages = {"com.example.testagg.repo.stations.endSheet"},
        mongoTemplateRef = EndSheetDbConfig.MONGO_TEMPLATE
)
public class EndSheetDbConfig {
    protected static final String MONGO_TEMPLATE = "newdb13MongoTemplate";
}
package com.example.testagg.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@Configuration
@EnableMongoRepositories(basePackages = {"com.example.testagg.repo.stations.bookAssembly"},
        mongoTemplateRef = BookAssemblyDbConfig.MONGO_TEMPLATE
)
public class BookAssemblyDbConfig {
    protected static final String MONGO_TEMPLATE = "newdb5MongoTemplate";
}
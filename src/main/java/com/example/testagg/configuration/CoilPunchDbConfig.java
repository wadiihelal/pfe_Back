package com.example.testagg.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.example.testagg.repo.stations.coilPunch"},
        mongoTemplateRef = CoilPunchDbConfig.MONGO_TEMPLATE
)
public class CoilPunchDbConfig {
    protected static final String MONGO_TEMPLATE = "newdb8MongoTemplate";
}
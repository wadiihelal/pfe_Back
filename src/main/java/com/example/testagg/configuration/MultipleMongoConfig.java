package com.example.testagg.configuration;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MultipleMongoConfig {
    @Primary
    @Bean(name = "newdb1Properties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.order")
    public MongoProperties getNewDb1Props() throws Exception {
        return new MongoProperties();
    }
    //station
    @Bean(name = "newdb2Properties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.machineetstation")
    public MongoProperties getNewDb2Props() throws Exception {
        return new MongoProperties();
    }
    //inventory
    @Bean(name = "newdb3Properties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.inventory")
    public MongoProperties getNewDb3Props() throws Exception {
        return new MongoProperties();
    }
    //binder
    @Bean(name = "newdb4Properties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.binder")
    public MongoProperties getNewDb4Props() throws Exception {
        return new MongoProperties();
    }
    //bookassembly
    @Bean(name = "newdb5Properties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.bookassembly")
    public MongoProperties getNewDb5Props() throws Exception {
        return new MongoProperties();
    }
    //casebinder
    @Bean(name = "newdb6Properties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.casebinder")
    public MongoProperties getNewDb6Props() throws Exception {
        return new MongoProperties();
    }
    //casemaker
    @Bean(name = "newdb7Properties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.casemaker")
    public MongoProperties getNewDb7Props() throws Exception {
        return new MongoProperties();
    }
    //CoilPunch
    @Bean(name = "newdb8Properties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.coilpunch")
    public MongoProperties getNewDb8Props() throws Exception {
        return new MongoProperties();
    }
    //cover
    @Bean(name = "newdb9Properties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.cover")
    public MongoProperties getNewDb9Props() throws Exception {
        return new MongoProperties();
    }
    //cutter
    @Bean(name = "newdb10Properties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.cutter")
    public MongoProperties getNewDb10Props() throws Exception {
        return new MongoProperties();
    }
    //diecutter
    @Bean(name = "newdb11Properties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.diecutter")
    public MongoProperties getNewDb11Props() throws Exception {
        return new MongoProperties();
    }
    //drill
    @Bean(name = "newdb12Properties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.drill")
    public MongoProperties getNewDb12Props() throws Exception {
        return new MongoProperties();
    }
    //endSheet
    @Bean(name = "newdb13Properties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.endsheet")
    public MongoProperties getNewDb13Props() throws Exception {
        return new MongoProperties();
    }
    //horizon

    @Bean(name = "newdb14Properties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.horizon")
    public MongoProperties getNewDb14Props() throws Exception {
        return new MongoProperties();
    }
    //hunkeler
    @Bean(name = "newdb15Properties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.hunkeler")
    public MongoProperties getNewDb15Props() throws Exception {
        return new MongoProperties();
    }
    //lamination
    @Bean(name = "newdb16Properties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.lamination")
    public MongoProperties getNewDb16Props() throws Exception {
        return new MongoProperties();
    }
    //press
    @Bean(name = "newdb17Properties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.press")
    public MongoProperties getNewDb17Props() throws Exception {
        return new MongoProperties();
    }
    //shrinkwrap
    @Bean(name = "newdb18Properties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.shrinkwrap")
    public MongoProperties getNewDb18Props() throws Exception {
        return new MongoProperties();
    }

    @Primary
    @Bean(name = "newdb1MongoTemplate")
    public MongoTemplate newdb1MongoTemplate() throws Exception {
        return new MongoTemplate(newdb1MongoDatabaseFactory(getNewDb1Props()));
    }
    @Bean(name = "newdb2MongoTemplate")
    public MongoTemplate newdb2MongoTemplate() throws Exception {
        return new MongoTemplate(newdb2MongoDatabaseFactory(getNewDb2Props()));
    }
    @Bean(name = "newdb3MongoTemplate")
    public MongoTemplate newdb3MongoTemplate() throws Exception {
        return new MongoTemplate(newdb3MongoDatabaseFactory(getNewDb3Props()));
    }
    @Bean(name = "newdb4MongoTemplate")
    public MongoTemplate newdb4MongoTemplate() throws Exception {
        return new MongoTemplate(newdb4MongoDatabaseFactory(getNewDb4Props()));
    }
    @Bean(name = "newdb5MongoTemplate")
    public MongoTemplate newdb5MongoTemplate() throws Exception {
        return new MongoTemplate(newdb5MongoDatabaseFactory(getNewDb5Props()));
    }
    @Bean(name = "newdb6MongoTemplate")
    public MongoTemplate newdb6MongoTemplate() throws Exception {
        return new MongoTemplate(newdb6MongoDatabaseFactory(getNewDb6Props()));
    }
    @Bean(name = "newdb7MongoTemplate")
    public MongoTemplate newdb7MongoTemplate() throws Exception {
        return new MongoTemplate(newdb7MongoDatabaseFactory(getNewDb7Props()));
    }
    @Bean(name = "newdb8MongoTemplate")
    public MongoTemplate newdb8MongoTemplate() throws Exception {
        return new MongoTemplate(newdb8MongoDatabaseFactory(getNewDb8Props()));
    }
    @Bean(name = "newdb9MongoTemplate")
    public MongoTemplate newdb9MongoTemplate() throws Exception {
        return new MongoTemplate(newdb9MongoDatabaseFactory(getNewDb9Props()));
    }
    @Bean(name = "newdb10MongoTemplate")
    public MongoTemplate newdb10MongoTemplate() throws Exception {
        return new MongoTemplate(newdb10MongoDatabaseFactory(getNewDb10Props()));
    }
    @Bean(name = "newdb11MongoTemplate")
    public MongoTemplate newdb11MongoTemplate() throws Exception {
        return new MongoTemplate(newdb11MongoDatabaseFactory(getNewDb11Props()));
    }
    @Bean(name = "newdb12MongoTemplate")
    public MongoTemplate newdb12MongoTemplate() throws Exception {
        return new MongoTemplate(newdb12MongoDatabaseFactory(getNewDb12Props()));
    }
    @Bean(name = "newdb13MongoTemplate")
    public MongoTemplate newdb13MongoTemplate() throws Exception {
        return new MongoTemplate(newdb13MongoDatabaseFactory(getNewDb13Props()));
    }
    @Bean(name = "newdb14MongoTemplate")
    public MongoTemplate newdb14MongoTemplate() throws Exception {
        return new MongoTemplate(newdb14MongoDatabaseFactory(getNewDb14Props()));
    }
    @Bean(name = "newdb15MongoTemplate")
    public MongoTemplate newdb15MongoTemplate() throws Exception {
        return new MongoTemplate(newdb15MongoDatabaseFactory(getNewDb15Props()));
    }
    @Bean(name = "newdb16MongoTemplate")
    public MongoTemplate newdb16MongoTemplate() throws Exception {
        return new MongoTemplate(newdb16MongoDatabaseFactory(getNewDb16Props()));
    }
    @Bean(name = "newdb17MongoTemplate")
    public MongoTemplate newdb17MongoTemplate() throws Exception {
        return new MongoTemplate(newdb17MongoDatabaseFactory(getNewDb17Props()));
    }
    @Bean(name = "newdb18MongoTemplate")
    public MongoTemplate newdb18MongoTemplate() throws Exception {
        return new MongoTemplate(newdb18MongoDatabaseFactory(getNewDb18Props()));
    }

    @Primary
    @Bean
    public MongoDatabaseFactory newdb1MongoDatabaseFactory(MongoProperties mongo) throws Exception {
        return new SimpleMongoClientDatabaseFactory(
                mongo.getUri()
        );
    }
    @Bean
    public MongoDatabaseFactory newdb2MongoDatabaseFactory(MongoProperties mongo) throws Exception {
        return new SimpleMongoClientDatabaseFactory(
                mongo.getUri()
        );
    }
    @Bean
    public MongoDatabaseFactory newdb3MongoDatabaseFactory(MongoProperties mongo) throws Exception {
        return new SimpleMongoClientDatabaseFactory(
                mongo.getUri()
        );
    }
    @Bean
    public MongoDatabaseFactory newdb4MongoDatabaseFactory(MongoProperties mongo) throws Exception {
        return new SimpleMongoClientDatabaseFactory(
                mongo.getUri()
        );
    }
    @Bean
    public MongoDatabaseFactory newdb5MongoDatabaseFactory(MongoProperties mongo) throws Exception {
        return new SimpleMongoClientDatabaseFactory(
                mongo.getUri()
        );
    }
    @Bean
    public MongoDatabaseFactory newdb6MongoDatabaseFactory(MongoProperties mongo) throws Exception {
        return new SimpleMongoClientDatabaseFactory(
                mongo.getUri()
        );
    }
    @Bean
    public MongoDatabaseFactory newdb7MongoDatabaseFactory(MongoProperties mongo) throws Exception {
        return new SimpleMongoClientDatabaseFactory(
                mongo.getUri()
        );
    }
    @Bean
    public MongoDatabaseFactory newdb8MongoDatabaseFactory(MongoProperties mongo) throws Exception {
        return new SimpleMongoClientDatabaseFactory(
                mongo.getUri()
        );
    }
    @Bean
    public MongoDatabaseFactory newdb9MongoDatabaseFactory(MongoProperties mongo) throws Exception {
        return new SimpleMongoClientDatabaseFactory(
                mongo.getUri()
        );
    }

    @Bean
    public MongoDatabaseFactory newdb10MongoDatabaseFactory(MongoProperties mongo) throws Exception {
        return new SimpleMongoClientDatabaseFactory(
                mongo.getUri()
        );
    }
    @Bean
    public MongoDatabaseFactory newdb11MongoDatabaseFactory(MongoProperties mongo) throws Exception {
        return new SimpleMongoClientDatabaseFactory(
                mongo.getUri()
        );
    }
    @Bean
    public MongoDatabaseFactory newdb12MongoDatabaseFactory(MongoProperties mongo) throws Exception {
        return new SimpleMongoClientDatabaseFactory(
                mongo.getUri()
        );
    }
    @Bean
    public MongoDatabaseFactory newdb13MongoDatabaseFactory(MongoProperties mongo) throws Exception {
        return new SimpleMongoClientDatabaseFactory(
                mongo.getUri()
        );
    }
    @Bean
    public MongoDatabaseFactory newdb14MongoDatabaseFactory(MongoProperties mongo) throws Exception {
        return new SimpleMongoClientDatabaseFactory(
                mongo.getUri()
        );
    }
    @Bean
    public MongoDatabaseFactory newdb15MongoDatabaseFactory(MongoProperties mongo) throws Exception {
        return new SimpleMongoClientDatabaseFactory(
                mongo.getUri()
        );
    }
    @Bean
    public MongoDatabaseFactory newdb16MongoDatabaseFactory(MongoProperties mongo) throws Exception {
        return new SimpleMongoClientDatabaseFactory(
                mongo.getUri()
        );
    }
    @Bean
    public MongoDatabaseFactory newdb17MongoDatabaseFactory(MongoProperties mongo) throws Exception {
        return new SimpleMongoClientDatabaseFactory(
                mongo.getUri()
        );
    }
    @Bean
    public MongoDatabaseFactory newdb18MongoDatabaseFactory(MongoProperties mongo) throws Exception {
        return new SimpleMongoClientDatabaseFactory(
                mongo.getUri()
        );
    }
}

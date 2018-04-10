package org.learn.mongodb.config;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

public class MongoConfig {

    @Bean
    public MongoClient mongoClient() {
        return new MongoClient();
    }

    @Autowired
    @Bean
    MongoTemplate mongoTemplate(MongoClient mongoClient,
                                @Value("${spring.data.mongodb.database}") String dbName) {

        MongoDbFactory factory = new SimpleMongoDbFactory(mongoClient, dbName);
        return new MongoTemplate(factory);
    }


}

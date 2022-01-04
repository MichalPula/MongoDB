package pulson.MONGODB.user;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "pulson.MONGODB")
public class MongoConfig {//lub extends AbstractMongoClientConfiguration i nadpisanie mongoClient + getMappingBasePackages

    @Autowired
    private Environment env;

    @Bean
    public MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString(env.getProperty("my.custom.mongodb.uri"));
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder().applyConnectionString(connectionString).build();
        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    public MongoTemplate mongoTemplate() {//public class MongoTemplate implements MongoOperations
        return new MongoTemplate(mongoClient(),"TestingMongoDB");
    }
}

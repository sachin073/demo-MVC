package webApp;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import webApp.dbConfig.MongoRepo;

/**
 * Created by sachin on 14/3/18.
 */

@Configuration
@EnableMongoRepositories(basePackageClasses = MongoRepo.class)
public class MongoConfig extends AbstractMongoConfiguration{

    @Override
    protected String getDatabaseName() {
        return "demo";
    }

    @Override
    public MongoClient mongoClient() {

        //TODO make mongoDB safe via credentials
        //use safe credentials here
        return new MongoClient(new ServerAddress("localhost",27017));
    }
}

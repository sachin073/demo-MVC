package webApp.dbConfig;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import webApp.employee.model.Employee;

/**
 * Created by sachin on 14/3/18.
 */
//gives some standard function and other can be listed below

public interface MongoRepo extends MongoRepository<Employee,String> {

    @Query("{_id:23}")
        public Employee findByEmpID();
}

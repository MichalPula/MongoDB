package pulson.MONGODB.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    //@Query("{firstName:'?0'}")
    //https://www.baeldung.com/spring-data-mongodb-projections-aggregations
    User findByFirstName(String firstName);
}

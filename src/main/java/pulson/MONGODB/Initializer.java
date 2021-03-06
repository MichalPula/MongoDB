package pulson.MONGODB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import pulson.MONGODB.user.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

@Service
public class Initializer {

    private final UserRepository userRepository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public Initializer(UserRepository userRepository, MongoTemplate mongoTemplate) {
        this.userRepository = userRepository;
        this.mongoTemplate = mongoTemplate;
        this.userRepository.deleteAll();

        testSpringMongoDB();
    }


    private void testSpringMongoDB() {
        Address address1 = new Address("Poland", "Warsaw", "40-400");
        Address address2 = new Address("USA", "Atlanta", "21-21");
        User user1 = new User("myCustomIndex1","someName", "pulson@gmail.com", GenderEnum.MALE,
                address1, Arrays.asList("Far Cry", "Assassin's Creed", "Battlefield"), new BigDecimal(3500), LocalDateTime.now().plusHours(2));
        User user2 = new User("someName", "21@gmail.com", GenderEnum.MALE,
                address2, Arrays.asList("21", "22", "23"), new BigDecimal(2121), LocalDateTime.now().plusHours(2));
        userRepository.insert(Arrays.asList(user1, user2));
        //mongoTemplate.insertAll(Arrays.asList(user1, user2));



        Query query = new Query().addCriteria(Criteria.where("firstName").is("someName"));
        Update update = new Update().set("firstName", "Micha??");

        mongoTemplate.updateFirst(query, update, User.class);//updatuje pierwszy dokument matchuj??cy Query
//        mongoTemplate.updateMulti(query, update, User.class);//updatuje wszystkie dokumenty matchuj??ce Query
//        User user = mongoTemplate.findAndModify(query, update, User.class);//dzia??a jak updateFirst, ale zwraca te?? obiekt w stanie sprzed operacji update
//        mongoTemplate.upsert(query, update, User.class);//je??li dokument wyst??puje w bazie - zostanie zupdatowany, je??li nie - dodany do bazy. Wyszukiwany jest pierwszy dokument matchuj??cy Query.
//        mongoTemplate.remove(query, User.class);//usunie wszystkie dokumenty matchuj??ce Query
//
//        boolean exists = mongoTemplate.exists(Query.query(Criteria.where("").is("someName")), User.class);
//
//        User foundUser = mongoTemplate.findOne(Query.query(Criteria.where("firstName").is("someName")), User.class);
        //Metody MongoTemplate.save(foundUser) i MongoRepository.save(foundUser) maj?? podw??jne dzia??anie - je??li dokument wyst??puje w bazie
        //zostanie zupdatowany, je??li nie - dodany do bazy. Wyszukiwany jest pierwszy dokument matchuj??cy Query.


//         List<User> usersSortedBySpentMoney = userRepository.findAll(Sort.by(Sort.Direction.ASC, "totalMoneySpentOnGames"));

         //https://stackoverflow.com/questions/17008947/whats-the-difference-between-spring-datas-mongotemplate-and-mongorepository
         //jak i kiedy u??ywa?? repository a kiedy pisa?? w??asne metody i gdzie to robi??
    }
}




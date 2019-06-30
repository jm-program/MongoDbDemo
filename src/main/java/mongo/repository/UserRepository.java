package mongo.repository;

import mongo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    public User getUserByName(String name);

    public User getUserByLastName(String lastName);

    public List<User> getUsersByLastName(String lastName);
}

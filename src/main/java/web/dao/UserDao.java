package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public interface UserDao {
    void addUser(User user, List<String> roles);

    List<User> getAllUsers();

    User getUserById(long id);

    User getUserByName(String name);

    void updateUser(User user, long id, List<String> role);

    void deleteUser(long id);
}

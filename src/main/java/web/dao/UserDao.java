package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public interface UserDao {
    public void addUser(User user, List<String> roles);

    public List<User> getAllUsers();

    public User getUserById(long id);

    public User getUserByName(String name);

    public void updateUser(User user, long id, List<String> role);

    public void deleteUser(long id);
}

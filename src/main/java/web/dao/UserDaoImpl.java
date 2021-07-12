package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> getAllUsers() {
        Query query = entityManager.createNamedQuery("User.getAll", User.class);
        return query.getResultList();
    }

    @Override
    public User getUserById(long id) {
        return getAllUsers().stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    @Override
    public User getUserByName(String name) {
        return getAllUsers().stream().filter(user -> user.getName().equals(name)).findAny().orElse(null);
    }

    @Override
    public void updateUser(User user, long id) {
        getUserById(id).setName(user.getName());
        entityManager.refresh(getUserById(id));
    }

    @Override
    public void deleteUser(long id) {
        entityManager.remove(getUserById(id));
    }
}

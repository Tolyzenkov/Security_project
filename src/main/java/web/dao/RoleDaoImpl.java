package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.Role;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    UserDao userDao;

    @Override
    public Role getRoleByRolename(String rolename) {

        return rolesList().stream().filter(role -> role.getName()
                .equals(rolename))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Role> rolesList() {
        Query query = entityManager.createNamedQuery("Role.getAll", Role.class);
        return query.getResultList();
    }

    @Override
    public Set<Role> setupRoles(User user, List<String> role) {
        Set<Role> roles = new HashSet<>();

        if (role.contains("ROLE_ADMIN")) {
            roles.add(getRoleByRolename("ROLE_ADMIN"));
        }
        if (role.contains("ROLE_USER")) {
            roles.add(getRoleByRolename("ROLE_USER"));
        }
        user.setRoles(roles);
        System.out.println(user.getRoles());
        return roles;
    }



}

package web.dao;

import org.springframework.stereotype.Component;
import web.model.Role;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Component
@Transactional
public interface RoleDao {
    Role getRoleByRolename(String rolename);
    List<Role> rolesList();
    Set<Role> setupRoles(User user, List<String> roleAdmin);


}

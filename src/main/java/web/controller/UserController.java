package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDao;
import web.model.Role;
import web.model.User;
import java.security.Principal;
import java.util.Set;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDao userDao;

	@GetMapping()
	public String showUserPage(ModelMap model, Principal principal) {
		User user = userDao.getUserByName(principal.getName());
		Set<Role> roles = user.getRoles();
		model.addAttribute("roles", roles);
		model.addAttribute("user", user);
		model.addAttribute("role", new Role());
		return "userDetails";
	}

}
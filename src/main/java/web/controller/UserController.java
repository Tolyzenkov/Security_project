package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;
import web.dao.UserDao;
import web.dao.UserDaoImpl;
import web.model.User;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDao userDao;

	@GetMapping()
	public String showUserPage(ModelMap model, Principal principal) {
		User user = userDao.getUserByName(principal.getName());
		model.addAttribute("user", user);
		return "userDetails";
	}

}
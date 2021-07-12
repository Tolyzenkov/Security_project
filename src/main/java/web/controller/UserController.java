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

@Controller
@RequestMapping("/")
public class UserController {

	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "admin", method = RequestMethod.GET)
	public String usersList(ModelMap model) {
        model.addAttribute("users", userDao.getAllUsers());
		return "index";
	}

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

	@GetMapping("new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        userDao.addUser(user);
        return "redirect:/";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userDao.getUserById(id));
        return "edit";
    }

    @PatchMapping("{id}")
    public String update(Model model, @ModelAttribute("user") User user,
                         @PathVariable("id") long id) {
        userDao.updateUser(user, id);
        return "redirect:/";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") long id) {
        userDao.deleteUser(id);
        return "redirect:/";
    }

}
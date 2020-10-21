package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.Sex;
import web.models.User;
import web.service.UserService;

@Controller
public class UsersController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public String viewUsers(Model model) {
        model.addAttribute("users", userService.showUsers());
        return "users";
    }

    @PostMapping(value = "/users")
    public String addUser(@RequestParam String fullname, @RequestParam Integer age, @RequestParam String sex) {
        userService.addUser(new User(fullname, age, sex.equals("male") ? Sex.MALE : Sex.FEMALE));
        return "redirect:/users";
    }

    @PostMapping(value = "/users", params = "edit")
    public String editUser(@RequestParam String fullname, @RequestParam Integer age, @RequestParam String sex, @RequestParam Boolean edit) {
        userService.updateUser(new User(fullname, age, sex.equals("male") ? Sex.MALE : Sex.FEMALE));
        return "redirect:/users";
    }

    @PostMapping(value = "/users", params = "delete")
    public String deleteUuser(@RequestParam Integer id, @RequestParam Boolean delete) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @PostMapping(value = "/user")
    public String showUser(Model model, @RequestParam Integer id) {
        model.addAttribute("user", userService.getUser(id));
        return "user";
    }

    @GetMapping(value = "/")
    public String justRedirect() {
        return "redirect:/users";
    }
}

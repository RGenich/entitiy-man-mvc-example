package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import web.models.User;
import web.service.RoleServiceImpl;
import web.service.UserService;

import java.util.stream.Collectors;

@Controller
public class UsersController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/user")
    public String deleteUser(@RequestParam Integer id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @GetMapping(value = "/user")
    public String showUserDetails(Model model, @RequestParam(required = false) Integer id,
                                  Authentication authentication, RedirectAttributes ra) {

        User currentUser = (User) authentication.getPrincipal();

        if (currentUser.getId() != id && !currentUser.getRoles().stream().map(t -> t.toString())
                .collect(Collectors.toList()).contains("ROLE_ADMIN")) {

            ra.addAttribute("id", currentUser.getId());
            return "redirect:/user";
        }

        User user = userService.getUser(id);
        model.addAttribute("user", user);
        model.addAttribute("role", new RoleServiceImpl());
        model.addAttribute("stringRoleList", user.getRoles().stream().map(t -> t.toString()).collect(Collectors.toList()));

        return "user";
    }

    @GetMapping(value = "/")
    public String justRedirect() {
        return "redirect:/users";
    }
}





package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String getAllUsers(@RequestParam(name = "id", required = false) Long editUserId,
                              Model model) {
        model.addAttribute("users", userService.listUsers());

        if (editUserId != null) {
            User user = userService.findUserById(editUserId);
            model.addAttribute("editUser", user);
        }

        return "users";
    }
    @PostMapping("/users")
    public String saveOrUpdateUser(@ModelAttribute User user) {
        userService.saveOrUpdateUser(user);
        return "redirect:/users";
    }

    @PostMapping("/users/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }
}
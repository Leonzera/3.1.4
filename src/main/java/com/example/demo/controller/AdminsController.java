package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminsController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String adminPanel(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "admin/index";
    }

    @GetMapping("/new")
    public String newUserForm(Model model) {
        model.addAttribute("user", new User());
        return "admin/user-form";
    }

//    @PostMapping("/save")
//    public String saveUser(@ModelAttribute User user, @RequestParam(value = "rolesList",required = false) String roleName) {
//        if (roleName != null && !roleName.isEmpty()) {
//            Role role = userDao.getRoleByName(roleName);
//            if (role != null) {
//                user.getRoles().add(role);
//            }
//        }
//        userService.saveOrUpdateUser(user);
//        return "redirect:/admin";
//    }
//    @PostMapping("/edit/{id}")
//    public String updateUser(@ModelAttribute("user") User user,
//                             @RequestParam(value = "rolesList", required = false) List<String> roles) {
//        if (roles != null && !roles.isEmpty()) {
//            Set<Role> roleSet = new HashSet<>();
//            for (String roleName : roles) {
//                roleSet.add(userService.getRoleByName(roleName));
//            }
//            user.setRoles(roleSet);
//        }
//        userService.saveOrUpdateUser(user);
//        return "redirect:/admin";
//    }
//
//    @PostMapping("/delete")
//    public String deleteUser(@ModelAttribute(name="id" )Long id) {
//        userService.deleteUserById(id);
//        return "redirect:/admin";
//    }
}
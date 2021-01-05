package com.savinpp.spring.mvc_hibernate.controller;

import com.savinpp.spring.mvc_hibernate.entity.Role;
import com.savinpp.spring.mvc_hibernate.entity.User;
import com.savinpp.spring.mvc_hibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class MyController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String showAllUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "all-users";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user-info";
    }

    @GetMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user,@ModelAttribute("role") Role role) {
        userService.saveUser(user);
        userService.saveRole(role);
        return "redirect:/admin";
    }

    @GetMapping("/saveRole")
    public String saveRole(@ModelAttribute("role") Role role) {
        userService.saveRole(role);
        return "redirect:/admin";
    }

    @GetMapping("/updateInfo/{id}")
    public String updateUser(@PathVariable("id") int id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "user-info";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(userService.getUser(id));
        return "redirect:/admin";
    }

    private Set<Role> getAddRole (String[] role) {
        Set<Role> roleSet=new HashSet<>();
        for (int i=0; i<role.length; i++) {
            roleSet.add(userService.getRoleByName(role[i]));
        }
        return roleSet;
    }

}
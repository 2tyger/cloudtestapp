package com.tygilbert.cloudtestapp.controller;

import com.tygilbert.cloudtestapp.model.User;
import com.tygilbert.cloudtestapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/users")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository repo;

    @GetMapping
    public String listUsers(Model model) {
        log.info("Fetching all users from database");
        model.addAttribute("users", repo.findAll());
        return "users";
    }

    @GetMapping("/add")
    public String addUserForm(Model model) {
        log.debug("Opening Add User form");
        model.addAttribute("user", new User());
        return "add-user";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user) {
        repo.save(user);
        log.info("User added: {}", user.getName());
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        repo.deleteById(id);
        log.warn("Deleted user with ID: {}", id);
        return "redirect:/users";
    }

}


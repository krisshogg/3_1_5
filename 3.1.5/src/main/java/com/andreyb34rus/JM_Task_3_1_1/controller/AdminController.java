package com.andreyb34rus.JM_Task_3_1_1.controller;

import com.andreyb34rus.JM_Task_3_1_1.model.User;
import com.andreyb34rus.JM_Task_3_1_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class AdminController {

    private UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String viewUsers(Principal principal, Model model) {
        User user = userService.getUserByName(principal.getName());
        model.addAttribute("user", user);
        return "usersList";
    }
}

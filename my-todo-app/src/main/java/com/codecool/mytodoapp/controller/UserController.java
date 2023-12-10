package com.codecool.mytodoapp.controller;

import com.codecool.mytodoapp.model.DAO.NewUserDAO;
import com.codecool.mytodoapp.model.user.User;
import com.codecool.mytodoapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody NewUserDAO newUserDAO) {
        return userService.registerUser(newUserDAO);
    }
}

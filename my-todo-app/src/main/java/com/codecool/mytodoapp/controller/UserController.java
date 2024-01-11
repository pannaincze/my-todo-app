package com.codecool.mytodoapp.controller;

import com.codecool.mytodoapp.model.DAO.UserDAO;
import com.codecool.mytodoapp.model.user.User;
import com.codecool.mytodoapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody UserDAO userDAO) {
        return userService.registerUser(userDAO);
    }

    @PatchMapping("/update/{id}")
    public User editUser(@PathVariable long id, @RequestBody UserDAO userDAO) {
        return userService.editUser(id, userDAO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }
}

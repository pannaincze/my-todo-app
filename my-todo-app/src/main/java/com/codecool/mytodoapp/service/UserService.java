package com.codecool.mytodoapp.service;

import com.codecool.mytodoapp.model.DAO.NewUserDAO;
import com.codecool.mytodoapp.model.user.User;
import com.codecool.mytodoapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User registerUser(NewUserDAO newUserDAO) {
        User user = new User();
        user.setName(newUserDAO.getName());
        user.setEmail(newUserDAO.getEmail());
        user.setPassword(newUserDAO.getPassword());
        user.setTodoLists(new ArrayList<>());

        return userRepository.save(user);
    }
}

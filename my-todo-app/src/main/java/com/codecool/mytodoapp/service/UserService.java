package com.codecool.mytodoapp.service;

import com.codecool.mytodoapp.model.DAO.UserDAO;
import com.codecool.mytodoapp.model.user.User;
import com.codecool.mytodoapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User registerUser(UserDAO userDAO) {
        User user = new User();
        user.setName(userDAO.getName());
        user.setEmail(userDAO.getEmail());
        user.setPassword(userDAO.getPassword());
        user.setTodoLists(new ArrayList<>());

        return userRepository.save(user);
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    public User editUser(long id, UserDAO userDAO) {
        User user  = userRepository.findById(id).orElseThrow();
        user.setId(id);
        user.setName(userDAO.getName());
        user.setEmail(userDAO.getEmail());
        user.setPassword(userDAO.getPassword());

        return userRepository.save(user);
    }
}

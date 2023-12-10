package com.codecool.mytodoapp.controller;

import com.codecool.mytodoapp.model.DAO.NewTodoListDAO;
import com.codecool.mytodoapp.model.notes.TodoList;
import com.codecool.mytodoapp.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoListController {
    private final TodoListService todoListService;

    @Autowired
    public TodoListController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @GetMapping("/home")
    public List<TodoList> getAllTodoLists() {
        return todoListService.getAllTodoLists();
    }

    @PostMapping("/new-todo")
    public TodoList createNewTodoList(@RequestBody NewTodoListDAO newTodoList) {
        return todoListService.createNewTodoList(newTodoList);
    }
}

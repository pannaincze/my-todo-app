package com.codecool.mytodoapp.controller;

import com.codecool.mytodoapp.model.DAO.NewTodoListDAO;
import com.codecool.mytodoapp.model.DAO.UpdateTodoListDAO;
import com.codecool.mytodoapp.model.notes.TodoList;
import com.codecool.mytodoapp.service.TodoListItemService;
import com.codecool.mytodoapp.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoListController {
    private final TodoListService todoListService;
    private final TodoListItemService todoListItemService;

    @Autowired
    public TodoListController(TodoListService todoListService, TodoListItemService todoListItemService) {
        this.todoListService = todoListService;
        this.todoListItemService = todoListItemService;
    }

    @GetMapping("/home")
    public List<TodoList> getAllTodoLists() {
        return todoListService.getAllTodoLists();
    }

    @PostMapping("/new-todo")
    public TodoList createNewTodoList(@RequestBody NewTodoListDAO newTodoList) {
        return todoListService.createNewTodoList(newTodoList);
    }

    @PatchMapping("/update/{id}")
    public TodoList editTodoList(@PathVariable long id, @RequestBody UpdateTodoListDAO updateTodoListDAO) {
        return todoListService.editTodoList(id, updateTodoListDAO);
    }

    @PatchMapping("/update/{todoListId}/check/{todoListItemId}")
    public TodoList editTodoListChecks(@PathVariable long todoListId, @PathVariable long todoListItemId) {
        return todoListItemService.editTodoListCheck(todoListId, todoListItemId);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteTodoList(@PathVariable long id) {
        todoListService.deleteTodoList(id);
    }
}

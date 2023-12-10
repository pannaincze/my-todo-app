package com.codecool.mytodoapp.service;

import com.codecool.mytodoapp.model.DAO.NewTodoListDAO;
import com.codecool.mytodoapp.model.notes.TodoList;
import com.codecool.mytodoapp.model.notes.TodoListItem;
import com.codecool.mytodoapp.model.user.User;
import com.codecool.mytodoapp.repository.TodoListRepository;
import com.codecool.mytodoapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoListService {
    private final TodoListRepository todoListRepository;
    private final UserRepository userRepository;
    private final TodoListItemRepository todoListItemRepository;

    public List<TodoList> getAllTodoLists() {
        return todoListRepository.findAll();
    }

    public TodoList createNewTodoList(NewTodoListDAO newTodoList) {
        User user = userRepository.findById(newTodoList.getUserId()).orElseThrow();
        TodoList todoList = TodoList.builder()
                .title(newTodoList.getTitle())
                .createdAt(LocalDate.now())
                .updatedAt(LocalDate.now())
                .user(user)
                .build();

        todoList = todoListRepository.save(todoList);

        List<TodoListItem> todoListItems = newTodoList.getListItems();
        for (TodoListItem item : todoListItems) {
            item.setTodoList(todoList);
        }
        todoListItemRepository.saveAll(todoListItems);

        todoList.setListItems(todoListItems);
        return todoListRepository.save(todoList);
    }
}

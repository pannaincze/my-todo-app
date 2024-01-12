package com.codecool.mytodoapp.service;

import com.codecool.mytodoapp.model.DAO.NewTodoListDAO;
import com.codecool.mytodoapp.model.DAO.UpdateTodoListDAO;
import com.codecool.mytodoapp.model.category.ToDoCategory;
import com.codecool.mytodoapp.model.notes.TodoList;
import com.codecool.mytodoapp.model.notes.TodoListItem;
import com.codecool.mytodoapp.model.user.User;
import com.codecool.mytodoapp.repository.ToDoCategoryRepository;
import com.codecool.mytodoapp.repository.TodoListItemRepository;
import com.codecool.mytodoapp.repository.TodoListRepository;
import com.codecool.mytodoapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class TodoListService {
    private final TodoListRepository todoListRepository;
    private final UserRepository userRepository;
    private final TodoListItemRepository todoListItemRepository;
    private final ToDoCategoryRepository toDoCategoryRepository;

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

        Set<ToDoCategory> savedCategories = getSavedCategories(newTodoList, todoList);

        todoList.setCategories(savedCategories);

        return todoListRepository.save(todoList);
    }

    private Set<ToDoCategory> getSavedCategories(NewTodoListDAO newTodoList, TodoList todoList) {
        List<TodoList> todoLists = new ArrayList<>();
        todoLists.add(todoList);

        Set<ToDoCategory> categories = newTodoList.getCategories();
        Set<ToDoCategory> savedCategories = new HashSet<>();
        for (ToDoCategory category : categories) {
            Optional<ToDoCategory> existingCategory = toDoCategoryRepository.findToDoCategoryByTitle(category.getTitle());
            if (existingCategory.isPresent()) {
                category = existingCategory.get();
            } else {
                category.setTodoLists(todoLists);
                toDoCategoryRepository.save(category);
            }
            savedCategories.add(category);
        }

        return savedCategories;
    }


    public TodoList editTodoList(long id, UpdateTodoListDAO updateTodoListDAO) {
        List<TodoListItem> todoListItems = updateTodoListDAO.getListItems();
        TodoList todoList = todoListRepository.findById(id).orElseThrow();
        todoList.setId(id);
        todoList.setTitle(updateTodoListDAO.getTitle());
        todoList.setCreatedAt(todoList.getCreatedAt());
        todoList.setUpdatedAt(LocalDate.now());

        for (TodoListItem item : todoListItems) {
            item.setTodoList(todoList);
        }

        todoList.getListItems().addAll(todoListItems);

        return todoListRepository.save(todoList);
    }

    public void deleteTodoList(long id) {
        todoListRepository.deleteById(id);
    }
}

package com.codecool.mytodoapp.service;

import com.codecool.mytodoapp.model.notes.TodoList;
import com.codecool.mytodoapp.model.notes.TodoListItem;
import com.codecool.mytodoapp.model.user.User;
import com.codecool.mytodoapp.repository.TodoListItemRepository;
import com.codecool.mytodoapp.repository.TodoListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoListItemService {
    private final TodoListItemRepository todoListItemRepository;
    private final TodoListRepository todoListRepository;

    public TodoList editTodoListCheck(long todoListId, long todoListItemId) {
        TodoList todoList = todoListRepository.findById(todoListId).orElseThrow();
        TodoListItem todoListItem = todoListItemRepository.findById(todoListItemId).orElseThrow();

        User user = todoList.getUser();
        user.setExperiencePoints(user.getExperiencePoints() + 10);

        todoListItem.setChecked(!todoListItem.isChecked());
        todoListItemRepository.save(todoListItem);

        return todoList;
    }
}

package com.codecool.mytodoapp.model.DAO;

import com.codecool.mytodoapp.model.category.ToDoCategory;
import com.codecool.mytodoapp.model.notes.TodoListItem;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class NewTodoListDAO {
    private String title;
    private Set<ToDoCategory> categories;
    private List<TodoListItem> listItems;
    private long userId;
}

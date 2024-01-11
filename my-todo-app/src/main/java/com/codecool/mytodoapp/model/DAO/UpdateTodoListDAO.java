package com.codecool.mytodoapp.model.DAO;

import com.codecool.mytodoapp.model.notes.TodoListItem;
import lombok.Data;

import java.util.List;

@Data
public class UpdateTodoListDAO {
    private String title;
    private List<TodoListItem> listItems;
}

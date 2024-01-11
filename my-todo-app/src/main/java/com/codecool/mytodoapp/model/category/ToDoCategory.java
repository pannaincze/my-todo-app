package com.codecool.mytodoapp.model.category;

import com.codecool.mytodoapp.model.notes.TodoList;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ToDoCategory {
    @Id
    @GeneratedValue
    private long id;
    private String title;

    @ManyToMany
    private List<TodoList> todoLists;
}

package com.codecool.mytodoapp.model.category;

import com.codecool.mytodoapp.model.notes.TodoList;
import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;

    @ManyToMany
    private List<TodoList> todoLists;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ToDoCategory category = (ToDoCategory) obj;
        return title.equals(category.title);
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }
}

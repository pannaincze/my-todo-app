package com.codecool.mytodoapp.model.user;

import com.codecool.mytodoapp.model.notes.TodoList;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String email;
    private String password;
    private int experiencePoints;
    private int level;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<TodoList> todoLists;

    public User() {
        this.experiencePoints = 0;
        this.level = 0;
    }
}

package com.codecool.mytodoapp.model.notes;

import com.codecool.mytodoapp.model.user.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class TodoList {
    @Id
    @GeneratedValue
    private long id;
    private String title;

    @OneToMany(mappedBy = "todoList", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<TodoListItem> listItems;

    private LocalDate createdAt;
    private LocalDate updatedAt;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
}


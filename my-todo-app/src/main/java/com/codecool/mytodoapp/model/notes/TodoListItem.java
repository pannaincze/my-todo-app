package com.codecool.mytodoapp.model.notes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class TodoListItem {
    @Id
    @GeneratedValue
    private long id;
    private String description;
    private boolean isChecked;

    @ManyToOne
    @JsonBackReference
    private TodoList todoList;

    public TodoListItem() {
        this.isChecked = false;
    }
}

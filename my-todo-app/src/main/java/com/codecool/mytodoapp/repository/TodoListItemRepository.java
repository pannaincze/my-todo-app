package com.codecool.mytodoapp.repository;

import com.codecool.mytodoapp.model.notes.TodoListItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoListItemRepository extends JpaRepository<TodoListItem, Long> {
}

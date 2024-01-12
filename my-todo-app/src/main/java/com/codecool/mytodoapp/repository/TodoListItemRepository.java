package com.codecool.mytodoapp.repository;

import com.codecool.mytodoapp.model.notes.TodoListItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoListItemRepository extends JpaRepository<TodoListItem, Long> {
    Optional<TodoListItem> findById(long id);
}

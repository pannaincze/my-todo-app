package com.codecool.mytodoapp.repository;

import com.codecool.mytodoapp.model.notes.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TodoListRepository extends JpaRepository<TodoList, Long> {
    Optional<TodoList> findById(long id);
    List<TodoList> findAllByUserId(long userId);
    void deleteById(long id);
}

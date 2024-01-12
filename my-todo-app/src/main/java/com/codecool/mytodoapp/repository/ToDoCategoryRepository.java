package com.codecool.mytodoapp.repository;

import com.codecool.mytodoapp.model.category.ToDoCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ToDoCategoryRepository extends JpaRepository<ToDoCategory, Long> {
    Optional<ToDoCategory> findToDoCategoryByTitle(String title);
}

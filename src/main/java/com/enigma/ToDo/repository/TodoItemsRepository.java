package com.enigma.ToDo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enigma.ToDo.entity.TodoItems;

@Repository
public interface TodoItemsRepository extends JpaRepository<TodoItems, String>{

}

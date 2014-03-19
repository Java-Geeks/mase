package io.github.javageeks.mase.repository;

import io.github.javageeks.mase.model.Todo;

import java.util.List;

/**
 * Interface for todo repository.
 */
public interface TodoRepository {

    /**
     * Save a todo.
     * @param todo the todo to save
     */
    void save(Todo todo);

    /**
     * Remove a todo.
     * @param todo the todo to remove
     */
    void remove(Todo todo);

    /**
     * Find a todo by id.
     * @param id the todo id
     * @return the todo if any or null if no todo is found with the given id
     */
    Todo findById(long id);

    /**
     * Find all todos.
     * @return all todos
     */
    List<Todo> findAll();

}

package io.github.javageeks.mase.service;

import io.github.javageeks.mase.model.Todo;

import java.util.List;

/**
 * Todo business service interface.
 */
public interface TodoService {

    /**
     * save or update a todo.
     * @param todo the todo to save or update
     * @return the created or updated todo
     */
    Todo saveOrUpdate(Todo todo);

    /**
     * Delete a todo.
     * @param todo the todo to delete
     */
    void delete(Todo todo);

    /**
     * Find a todo by its Id.
     * @param id the todo id
     * @return the todo with the given id or null if no todo found with the given id
     */
    Todo findById(String id);

    /**
     * Return all todos.
     * @return all todos
     */
    List<Todo> findAll();

}

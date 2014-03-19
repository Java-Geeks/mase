package io.github.javageeks.mase.service;

import io.github.javageeks.mase.model.Todo;

import java.util.List;

/**
 * Todo business service interface.
 */
public interface TodoService {

    void create(Todo todo);

    void delete(Todo todo);

    Todo findById(long id);

    List<Todo> findAll();

}

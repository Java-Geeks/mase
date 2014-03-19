package io.github.javageeks.mase.service.impl;

import io.github.javageeks.mase.model.Todo;
import io.github.javageeks.mase.repository.TodoRepository;
import io.github.javageeks.mase.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Todo business service implementation.
 */
@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public void create(Todo todo) {
        todoRepository.save(todo);
    }

    @Override
    public void delete(Todo todo) {
        todoRepository.remove(todo);
    }

    @Override
    public Todo findById(long id) {
        return todoRepository.findById(id);
    }

    @Override
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

}

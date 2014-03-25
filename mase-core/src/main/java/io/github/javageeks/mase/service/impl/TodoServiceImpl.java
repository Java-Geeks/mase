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
    public Todo saveOrUpdate(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public void delete(Todo todo) {
        todoRepository.delete(todo);
    }

    @Override
    public Todo findById(String id) {
        return todoRepository.findOne(id);
    }

    @Override
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

}

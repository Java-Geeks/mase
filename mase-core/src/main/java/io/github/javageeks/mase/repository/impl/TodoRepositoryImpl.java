package io.github.javageeks.mase.repository.impl;

import io.github.javageeks.mase.model.Todo;
import io.github.javageeks.mase.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Implementation of {@link TodoRepository}
 */
@Repository
public class TodoRepositoryImpl implements TodoRepository {

    @Autowired
    private MongoOperations mongoTemplate;

    /**
     * {@inheritDoc}
     */
    public void save(Todo todo) {
        mongoTemplate.save(todo);
    }

    /**
     * {@inheritDoc}
     */
    public void remove(Todo todo) {
        mongoTemplate.remove(todo);
    }

    /**
     * {@inheritDoc}
     */
    public Todo findById(long id) {
        return mongoTemplate.findById(id, Todo.class);
    }

    /**
     * {@inheritDoc}
     */
    public List<Todo> findAll() {
        return mongoTemplate.findAll(Todo.class);
    }

}

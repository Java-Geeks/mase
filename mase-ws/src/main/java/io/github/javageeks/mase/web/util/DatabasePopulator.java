package io.github.javageeks.mase.web.util;

import io.github.javageeks.mase.model.Todo;
import io.github.javageeks.mase.service.TodoService;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Utility bean used to populate the database with fake data at application's startup.
 */
@Profile("dev")
@Component
public class DatabasePopulator {

    @Autowired
    private TodoService todoService;

    @PostConstruct
    public void populateDatabase() {

        Todo todo = new Todo();
        todo.setId(1);
        todo.setUserId(1);
        todo.setTitle("Milk");
        todo.setDescription("Remember the milk!");
        todo.setStatus(false);
        todoService.create(todo);

    }

}

package io.github.javageeks.mase.web.util;

import io.github.javageeks.mase.model.Todo;
import io.github.javageeks.mase.model.User;
import io.github.javageeks.mase.service.TodoService;

import javax.annotation.PostConstruct;

import io.github.javageeks.mase.service.UserService;
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

    @Autowired
    private UserService userService;

    @PostConstruct
    public void populateDatabase() {
    	if (userService.findByEmail("foo@bar.org") == null) {
	        User user = new User();
	        user.setFirstName("Foo");
	        user.setLastName("Bar");
	        user.setEmail("foo@bar.org");
	        user.setPassword("foobar");
	        user = userService.saveOrUpdate(user);
	        
	        Todo todo = new Todo();
	        todo.setUserId(user.getId());
	        todo.setTitle("Milk");
	        todo.setDescription("Remember the milk!");
	        todo.setStatus(false);
	        todoService.saveOrUpdate(todo);
    	}

    	

    }

}

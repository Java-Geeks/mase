package io.github.javageeks.mase.service.test;

import io.github.javageeks.mase.model.Todo;
import io.github.javageeks.mase.repository.TodoRepository;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/mase-core-context.xml"})
public class TodoRepositoryTest {

    @Autowired
    private TodoRepository todoRepository;


    @Ignore
    @Test
    public void testTodoRepository() {

        todoRepository.deleteAll();

        Todo todo = new Todo();
        todo.setUserId("1");
        todo.setTitle("Todo1");
        todo.setDescription("Todo1 for user1");
        todo.setStatus(false);
        todoRepository.save(todo);

        List<Todo> todos = todoRepository.findAll();
        assertEquals(1, todos.size());
    }

}
package io.github.javageeks.mase.service.test;

import io.github.javageeks.mase.model.Todo;
import io.github.javageeks.mase.service.TodoService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/mase-core-context.xml"})
public class TodoServiceTest {

    @Autowired
    private TodoService todoService;

    @Ignore
    @Test
    public void testTodoService() {

        //create a todo for test
        Todo todo = new Todo();
        todo.setUserId(1);
        todo.setTitle("Test Todo");
        todo.setDescription("Todo used for test");
        todo.setStatus(false);
        todoService.saveOrUpdate(todo);

        // test findById
        Todo t = todoService.findById("1");
        assertEquals("1", t.getId());
        assertEquals(1, t.getUserId());
        assertEquals("Test Todo", t.getTitle());
        assertEquals("Todo used for test", t.getDescription());
        assertEquals(false, t.getStatus());

        //test find all
        List<Todo> todos = todoService.findAll();
        assertEquals(1, todos.size());

    }

}
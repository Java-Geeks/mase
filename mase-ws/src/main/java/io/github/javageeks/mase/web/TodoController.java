package io.github.javageeks.mase.web;

import io.github.javageeks.mase.model.Todo;
import io.github.javageeks.mase.service.TodoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Todo rest web service.
 */
@Controller
public class TodoController {

    @Autowired
    private TodoService todoService;

    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    public @ResponseBody List<Todo> getAllTodo() {
    	return todoService.findAll();
    }
    @RequestMapping(value = "/todos/{todoId}", method = RequestMethod.GET)
    public @ResponseBody
    Todo getTodo(@PathVariable long todoId) {
        return todoService.findById(todoId);
    }

}

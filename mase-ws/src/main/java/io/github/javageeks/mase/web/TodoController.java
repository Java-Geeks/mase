package io.github.javageeks.mase.web;

import io.github.javageeks.mase.model.Todo;
import io.github.javageeks.mase.service.TodoService;

import java.util.List;

import io.github.javageeks.mase.web.util.SessionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Todo rest web service.
 */
@Controller
public class TodoController {

	@Autowired
	private TodoService todoService;

    @Autowired
    private SessionData sessionData;

	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public @ResponseBody
	List<Todo> getAllTodo() {
		return todoService.findAll(sessionData.getUser().getId());
	}

	@RequestMapping(value = "/todos/{todoId}", method = RequestMethod.GET)
	public @ResponseBody
	Todo getTodo(@PathVariable String todoId) {
		return todoService.findById(todoId);
	}

	@RequestMapping(value = "/todos", method = RequestMethod.POST)
	public @ResponseBody
	Todo createTodo(@RequestBody Todo todo) {
        return todoService.saveOrUpdate(todo);
	}

	@RequestMapping(value = "/todos/{todoId}", method = RequestMethod.PUT)
	public @ResponseBody
	Todo editTodo(@RequestBody Todo todo) {
		return todoService.saveOrUpdate(todo);
	}

	@RequestMapping(value = "/todos/{todoId}", method = RequestMethod.DELETE)
	public @ResponseBody
	void deleteTodo(@PathVariable String todoId) {
		Todo todo = todoService.findById(todoId);
		todoService.delete(todo);
	}

}

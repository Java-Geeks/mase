package io.github.javageeks.mase.web;

import io.github.javageeks.mase.model.Todo;
import io.github.javageeks.mase.service.TodoService;

import java.util.List;

import javax.ws.rs.core.Response;

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
	public @ResponseBody
	List<Todo> getAllTodo() {
		return todoService.findAll();
	}

	@RequestMapping(value = "/todos/{todoId}", method = RequestMethod.GET)
	public @ResponseBody
	Todo getTodo(@PathVariable long todoId) {
		return todoService.findById(todoId);
	}

	@RequestMapping(value = "/todos/{todoId}", method = RequestMethod.POST)
	public @ResponseBody
	String createTodo(Todo todo) {
		todoService.create(todo);
		return todo.toString();
	}

	@RequestMapping(value = "/todos/{todoId}", method = RequestMethod.PUT)
	public @ResponseBody
	String editTodo(Todo todo) {
		// update with mongo template save method
		todoService.create(todo);
		return todo.toString();
	}

	@RequestMapping(value = "/todos/{todoId}", method = RequestMethod.DELETE)
	public @ResponseBody
	String deleteTodo(@PathVariable long todoId) {
		Todo todo = todoService.findById(todoId);
		todoService.delete(todo);
		return Response.ok().toString();
	}

}

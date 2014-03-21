package io.github.javageeks.mase.web;

import io.github.javageeks.mase.model.Todo;
import io.github.javageeks.mase.service.TodoService;
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

    @RequestMapping(value = "/todos/{todoId}", method = RequestMethod.GET)
    public @ResponseBody
    Todo getTodo(@PathVariable long todoId) {
        return todoService.findById(todoId);
    }

}

package com.optivem.atddaccelerator.template.monolith.controllers;

import com.optivem.atddaccelerator.template.monolith.models.Todo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    @GetMapping("/todos/{id}")
    @ResponseBody
    public Todo getTodo(@PathVariable int id) {
        // For simplicity, returning a mock todo with the requested ID
        // In a real application, this would fetch from a database
        return new Todo(1, id, "delectus aut autem", false);
    }
}
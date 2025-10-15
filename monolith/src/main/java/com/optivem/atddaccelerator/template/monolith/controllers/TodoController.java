package com.optivem.atddaccelerator.template.monolith.controllers;

import com.optivem.atddaccelerator.template.monolith.models.Todo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TodoController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/todos/{id}")
    @ResponseBody
    public Todo getTodo(@PathVariable int id) {
        String url = "https://jsonplaceholder.typicode.com/todos/" + id;
        return restTemplate.getForObject(url, Todo.class);
    }
}
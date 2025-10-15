package com.optivem.atddaccelerator.template.monolith.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "Hello World!";
    }

    @GetMapping("/echo")
    @ResponseBody
    public String echo() {
        return "Echo";
    }
}
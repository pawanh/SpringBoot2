package com.pawan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(path = "/greet")
    public String greeting() {
        return "Hello";
    }
}

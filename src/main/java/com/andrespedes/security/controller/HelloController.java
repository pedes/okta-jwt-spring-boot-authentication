package com.andrespedes.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello(){
        return "Hello from the REST Controller";
    }


    @PostMapping("/")
    public String helloPost(@RequestParam("name") String name){
        return "Welcome back! " + name;
    }
    
}
package com.matthew.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${com.matthew.project.author.name}")
    private String authorName;

    @Value("${com.matthew.project.author.email}")
    private String authorEmail;

    @RequestMapping("/hello")
    public String index() {
        StringBuilder stringBuilder = new StringBuilder("Hello World\r\n");
        stringBuilder.append("author name: " + authorName + "\r\n").append("author email: " + authorEmail + "\r\n");
        return stringBuilder.toString();
    }
}

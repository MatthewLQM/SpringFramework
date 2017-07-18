package com.matthew.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huafu on 17-7-18.
 */
@RestController
public class IndexController {
    @RequestMapping(value = {"/", "", "/index"})
    public String index(){
        return "Welcome to Spring Boot";
    }
}

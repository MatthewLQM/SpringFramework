package com.matthew.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by huafu on 17-7-19.
 */
@Controller
public class ErrorController {

    @GetMapping(value = "/404")
    public String notFound(){
        return "404Page";
    }

    @GetMapping(value = "/500")
    public String serverError(){
        return "500Page";
    }
}

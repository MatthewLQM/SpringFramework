package com.matthew.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by huafu on 17-7-19.
 */
@Controller
@RequestMapping(value = "/springLearning")
public class SpringLearningController {
    @RequestMapping(value = "/problem", method = RequestMethod.GET)
    public String problem(Model model){
        return "springLearningProblemPage";
    }
}

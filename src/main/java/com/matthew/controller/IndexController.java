package com.matthew.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @RequestMapping(method = RequestMethod.GET, value = {"/", "", "/index"})
    public String index(HttpServletRequest request, Model model){
        return "indexPage";
    }
}

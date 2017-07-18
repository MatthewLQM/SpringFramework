package com.matthew.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by huafu on 17-7-18.
 */
@Controller
public class IndexController {
    @RequestMapping(method = RequestMethod.GET, value = {"/", "", "/index"})
    public String index(HttpServletRequest request, Model model){
        return "indexPage";
    }
}

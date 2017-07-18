package com.matthew.controller;

import com.matthew.component.AuthorInfoComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ContactUsController {
    @Autowired
    AuthorInfoComponent authorInfoComponent;

    @RequestMapping(method = RequestMethod.GET, value = "/contactus")
    public String contactUs(HttpServletRequest request, Model model){
        model.addAttribute("projectInfoName", authorInfoComponent.getName());
        model.addAttribute("projectInfoAuthor", authorInfoComponent.getAuthor());
        model.addAttribute("projectInfoEmail", authorInfoComponent.getEmail());
        return "contactUsPage";
    }
}

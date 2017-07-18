package com.matthew.controller;

import com.matthew.common.argument.AutoGeneratorArguments;
import com.matthew.service.AutoGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
public class AutoGeneratorController {

    @Autowired
    AutoGeneratorService autoGeneratorService;

    @RequestMapping(method = RequestMethod.GET, value = "/autogenerator")
    public String autuGeneratorGet(){
        return "autoGeneratorPage";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/autogenerator")
    public String autuGeneratorPost(HttpServletRequest request, Model model){
        String originString = request.getParameter("originString");
        String begin = request.getParameter("begin");
        String end = request.getParameter("end");
        AutoGeneratorArguments arguments = buildArguments(originString, begin, end);
        List<String> strings = autoGeneratorService.autoGenerate(arguments);
        String result = convertToString(strings);
        model.addAttribute("result", result);
        return "autoGeneratorResultPage";
    }

    private AutoGeneratorArguments buildArguments(String originString, String begin, String end){
        AutoGeneratorArguments arguments = new AutoGeneratorArguments();
        arguments.setOriginString(originString);
        arguments.setBegin(Arrays.asList(Integer.valueOf(begin)));
        arguments.setEnd(Arrays.asList(Integer.valueOf(end) + 1));
        return arguments;
    }

    private String convertToString(List<String> strings){
        String result = new String();
        for(String string : strings){
            result += string;
            result += "\n";
        }
        return result;
    }
}

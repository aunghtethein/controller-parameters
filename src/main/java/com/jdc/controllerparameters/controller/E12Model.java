package com.jdc.controllerparameters.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class E12Model {
    //http://localhost:8080/actionM1
    @GetMapping("actionM1")
    public String actionM1(Map<String, String> model){
        model.put("firstName","John");
        model.put("lastName","Doe");
        model.put("email","john@gmail.com");
        model.put("city","London");
        return "address";
    }

    //http://localhost:8080/actionM2
    @GetMapping("actionM2")
    public String actionM2(Model model){
        model.addAttribute("firstName","John");
        model.addAttribute("lastName","Doe");
        model.addAttribute("email","john@gmail.com");
        model.addAttribute("city","London");
        return "address";
    }
    //http://localhost:8080/actionM3
    @GetMapping("actionM3")
    public String actionM2(ModelMap model){
        model.addAttribute("firstName","John");
        model.addAttribute("lastName","Doe");
        model.addAttribute("email","john@gmail.com");
        model.addAttribute("city","London");
        return "address";
    }

    //http://localhost:8080/actionM4
    @GetMapping("actionM4")
    public ModelAndView actionM4(){
        ModelAndView mv = new ModelAndView();

        mv.addObject("firstName","John");
        mv.addObject("lastName","Doe");
        mv.addObject("email","john@gmail.com");
        mv.addObject("city","London");
        mv.setViewName("address");
        return mv;
    }
}

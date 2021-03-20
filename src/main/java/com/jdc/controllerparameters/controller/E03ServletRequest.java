package com.jdc.controllerparameters.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;

@Controller
public class E03ServletRequest {
    //curl localhost:8080/actionC
    @ResponseBody
    @GetMapping("/actionC")
    public String actionC(ServletRequest servletRequest){
        return String.format("Retrieved request on server = [%s:%d]\n",servletRequest.getServerName(),servletRequest.getServerPort());
    }
}

package com.jdc.controllerparameters.controller;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class E07HttpMethod {

    //curl -X GET localhost:8080/actionG
    //curl -X POST localhost:8080/actionG
    //curl -X PUT localhost:8080/actionG

    @ResponseBody
    @RequestMapping("/actionG")
    public String actionG(HttpMethod httpMethod){
        return String.format("Http Method = [%s]",httpMethod);

    }

}

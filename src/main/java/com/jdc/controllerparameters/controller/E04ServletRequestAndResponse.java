package com.jdc.controllerparameters.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

@Controller
public class E04ServletRequestAndResponse {
    //curl localhost:8080/actionD
    @ResponseBody
    @GetMapping("/actionD")
    public void actionD(ServletRequest request, ServletResponse response)throws IOException {
        response.getOutputStream().println(
                String.format("Retrieved request on server = [%s:%d]",request.getServerName(),request.getServerPort())
        );
    }
}

package com.jdc.controllerparameters.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import static com.jdc.controllerparameters.util.JoinUtils.join;
@Controller
public class E01WebRequest {

    //curl "localhost:8080/actionA?name=Hein&country=Myanmar"
    @GetMapping("/actionA")
    @ResponseBody
    public String actionA(WebRequest webRequest){
        return String.format(
                "Retrieved requests with headers = [%s], parameters = [%s]\n",
                    join(webRequest.getHeaderNames()),
                    join(webRequest.getParameterNames())
                );
    }
}

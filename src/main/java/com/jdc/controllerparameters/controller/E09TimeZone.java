package com.jdc.controllerparameters.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.ZoneId;
import java.util.TimeZone;

@Controller
public class E09TimeZone {

    //curl localhost:8080/actionI
    @ResponseBody
    @RequestMapping("/actionI")
    public String actionI(TimeZone timeZone, ZoneId zoneId){
        return String.format("Time Zone = [%s]\n, Zone Id = [%s]",timeZone.getDisplayName(),zoneId.getId());
    }

}

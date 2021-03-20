package com.jdc.controllerparameters.controller;

import com.jdc.controllerparameters.ds.Address;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class E11HttpEntity {
    //curl -X POST -H 'Content-Type: application/json' -d '{"firstName":"john","lastName":"doe","streetAddress":"455 Dream. Apt 23","city":"New York","stateCode":"CA","zipCode":"93423","country":"US"}' localhost:8080/actionK
    @PostMapping("/actionK")
    @ResponseBody
    public String actionK(HttpEntity<Address> httpEntity){
        return String.format(
                "Received request from host = [%s], \n Address = [%s] \n",
                httpEntity.getHeaders().getHost(),
                httpEntity.getBody()
        );
    }
}

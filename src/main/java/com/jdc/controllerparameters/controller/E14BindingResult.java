package com.jdc.controllerparameters.controller;

import com.jdc.controllerparameters.ds.Address;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class E14BindingResult {

    @GetMapping("actionL1")
    public String actionL1(@ModelAttribute Address address){
        return "address-form";
    }
    @PostMapping("/actionL1")
    public String actionL1Submit(@ModelAttribute @Valid Address address, BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors()){
            return "address-form";
        }
        redirectAttributes.addFlashAttribute(address);
        return "redirect:/actionL1/ok";
    }
    @GetMapping("/actionL1/ok")
    public String actionOk(@ModelAttribute Address address){
        return "address-form-ok";
    }
}

package com.jdc.controllerparameters.controller;

import com.jdc.controllerparameters.dao.AddressDao;
import com.jdc.controllerparameters.ds.Address;
import com.jdc.controllerparameters.ds.Country;
import com.jdc.controllerparameters.ds.Person;
import com.jdc.controllerparameters.ds.ShortAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.StringTokenizer;

@Controller
@SessionAttributes({"person","shortAddress","country"})
public class E15SessionAttribute {
    @Autowired
    private AddressDao addressDao;

    @GetMapping("actionP")
    public String actionP(Model model){
        model.addAttribute("addresses",addressDao.findAll());
        return "addresses-list";
    }
    @GetMapping("/actionP/address/step1")
    public String actionPStep1(@ModelAttribute("person")Person person){
        return "address-form-step1";
    }
    @PostMapping("/actionP/address/step1")
    public String actionPStep2(@ModelAttribute("person")@Valid Person person, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "address-form-step1";
        }
        else {
            return "redirect:/actionP/address/step2";
        }
    }
    @GetMapping("/actionP/address/step2")
    public String actionPStep2(@ModelAttribute("shortAddress")ShortAddress shortAddress){
        return "address-form-step2";
    }
    @PostMapping("/actionP/address/step2")
    public String actionPStep2(@ModelAttribute("shortAddress")@Valid ShortAddress shortAddress,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "address-form-step2";
        }
        else {
            return "redirect:/actionP/address/step3";
        }
    }
    @GetMapping("/actionP/address/step3")
    public String actionPStep3(@ModelAttribute("country")Country country){
        return "address-form-step3";
    }
    @PostMapping("/actionP/address/step3")
    public String actionPStep3(@ModelAttribute("country")@Valid Country country, BindingResult bindingResult,
                               @ModelAttribute("shortAddress")ShortAddress shortAddress,
                               @ModelAttribute("person")Person person, SessionStatus sessionStatus){
       if (bindingResult.hasErrors()){
           return "address-form-step3";
       }
       else{
           Address address = new Address(person,shortAddress,country);
           addressDao.save(address);
           sessionStatus.setComplete();
           return "redirect:/actionP";
       }
    }

    @ModelAttribute("person")
    public Person person(){
        return new Person();
    }
    @ModelAttribute("shortAddress")
    public ShortAddress shortAddress(){
        return new ShortAddress();
    }
    @ModelAttribute("country")
    public Country country(){
        return new Country();
    }
}

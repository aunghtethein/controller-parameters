package com.jdc.controllerparameters.ds;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Person {
    @NotBlank(message = "First Name can't be empty!")
    private String firstName;
    @NotBlank(message = "Last Name can't be empty!")
    private String lastName;
}

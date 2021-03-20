package com.jdc.controllerparameters.ds;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class Country {
    @NotBlank(message = "Country name can't be empty!")
    @Pattern(regexp = "[A-Za-z ]*")
    private String country;
}

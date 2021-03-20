package com.jdc.controllerparameters.ds;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class ShortAddress {
    @NotBlank(message = "Street Address can't be empty")
    private String streetAddress;
    @NotBlank(message = "City name can't be empty")
    private String city;
    @Pattern(regexp = "[A-Z]{2}", message = "State Code needs to be 2 letter code.")
    private String stateCode;
    @Pattern(regexp = "\\d{5}", message = "Zip Code needs to be 5 digit.")
    private String zipCode;
}

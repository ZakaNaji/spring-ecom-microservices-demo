package com.znaji.ecom.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Address {

    private String street;
    private String city;
    private String zip;
    private String country;
}

package com.znaji.ecom.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @GetMapping("/customers/ping")
    public String ping() {
        return "customer-service up";
    }
}
package com.example.cloud.api.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/userServiceFallBackMethod")
    public String userServiceFallBackMethod(){
        return "User service is taking longer than expected, Please try again later";
    }

    @GetMapping("/departmentServiceFallBackMethod")
    public String departmentServiceFallBackMethod(){
        return "department service is taking longer than expected, Please try again later";
    }
}

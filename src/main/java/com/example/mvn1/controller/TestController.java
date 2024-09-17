package com.example.mvn1.controller;

import com.example.mvn1.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    TestService testService;
    @GetMapping("/test/{str}")

    public String test(@PathVariable String str) {

        return "palindrome status : "+testService.isPalindrome(str);
    }
}

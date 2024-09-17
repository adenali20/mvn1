package com.example.mvn1.controller;

import com.example.mvn1.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {
    @Autowired
    TestService testService;
    @GetMapping("/test/{str}")

    public Map<String,Boolean> isPalindrome(@PathVariable String str) {

        Map<String,Boolean> res=new HashMap<>();
        res.put(str,testService.isPalindrome(str));
        return res;
    }
}

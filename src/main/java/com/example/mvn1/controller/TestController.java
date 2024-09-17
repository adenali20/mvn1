package com.example.mvn1.controller;

import com.example.mvn1.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@CrossOrigin(origins = "http://localhost:3000")
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

    @GetMapping("/users")
    public List<String> isPalindrome() {

       List<String> list=new ArrayList<>();
       list.add("aden");
       list.add("mohamed");
       list.add("ali");
        return list;
    }
}

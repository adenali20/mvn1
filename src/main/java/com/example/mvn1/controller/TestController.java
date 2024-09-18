package com.example.mvn1.controller;

import com.example.mvn1.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TestController {
    @Autowired
    TestService testService;

    List<String> list=new ArrayList<>();


    @GetMapping("/test/{str}")
    public Map<String,Boolean> isPalindrome(@PathVariable String str) {

        Map<String,Boolean> res=new HashMap<>();
        res.put(str,testService.isPalindrome(str));
        return res;
    }

    @GetMapping("/users")
    public List<String> getUsers() {

        return list;
    }

    @GetMapping("/deleteUsers")
    public List<String> deleteUsers() {
        list.clear();
        return list;
    }


    @PostMapping("/users")
    public List<String> postUser(@RequestBody String user) {


        list.add(user);
        return list;
    }
}

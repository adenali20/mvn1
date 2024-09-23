package com.example.mvn1.controller;

import com.example.mvn1.entity.User;
import com.example.mvn1.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/api/users")
public class TestController {
    @Autowired
    TestService testService;




    @GetMapping("/test/{str}")
    public Map<String,Boolean> isPalindrome(@PathVariable String str) {

        Map<String,Boolean> res=new HashMap<>();
        res.put(str,testService.isPalindrome(str));
        return res;
    }

    @GetMapping("/")
    public List<String> getUsers() {

        return testService.getAllUsers().stream().map(e->e.getName()).collect(Collectors.toUnmodifiableList());
    }

    @GetMapping("/deleteUsers")
    public List<String> deleteUsers() {
        System.out.println("deleting is not done");
        return new ArrayList<>();
    }


    @PostMapping("/")
    public List<String> postUser(@RequestBody String user) {


        User user1=new User();
        user1.setName(user);
        testService.saveUser(user1);
        return testService.getAllUsers().stream().map(e->e.getId()+". "+e.getName()).collect(Collectors.toList());
    }
}

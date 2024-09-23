package com.example.mvn1.service;

import com.example.mvn1.entity.User;
import com.example.mvn1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TestService {

    @Autowired
    UserRepository userRepository;
    public boolean isPalindrome(String inputString) {
        StringBuilder sb=new StringBuilder(inputString);

        return sb.reverse().toString().equalsIgnoreCase(inputString);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        List<User> users=userRepository.findAll();
        Collections.reverse(users);

        return users;
    }
}

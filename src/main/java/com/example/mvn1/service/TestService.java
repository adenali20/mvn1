package com.example.mvn1.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {
    public boolean isPalindrome(String inputString) {
        StringBuilder sb=new StringBuilder(inputString);

        return sb.reverse().toString().equalsIgnoreCase(inputString);
    }
}

package com.example.mvn1.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {
    public boolean isPalindrome(String inputString) {
        String reversedString = "";
        for(char c : inputString.toCharArray()) {
            reversedString = c+reversedString;
        }
        return reversedString.equals(inputString);
    }
}

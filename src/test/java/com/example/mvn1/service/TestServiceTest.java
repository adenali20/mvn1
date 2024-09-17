package com.example.mvn1.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TestServiceTest {

    @InjectMocks
    TestService testService;

    @Test
    void contextLoads() {
    }

    @Test
    public void whenPalindromeThenTrue() {
        assertTrue(testService.isPalindrome("xsx"));
    }

    @Test
    public void whenNotPalindromeThenFalse() {
        assertFalse(testService.isPalindrome("xs"));
    }

}
package com.example.mvn1.service;

import com.example.mvn1.entity.User;
import com.example.mvn1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.mvn1.entity.User;


@Service
public class UserService {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;


    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return  user;
    }



    public User findByUserName(String userName) {


        return userRepository.findByUserName(userName).get();
    }
}

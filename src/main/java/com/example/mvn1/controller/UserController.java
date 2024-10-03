package com.example.mvn1.controller;


import com.example.mvn1.constants.ApplicationConstants;
import com.example.mvn1.entity.User;
import com.example.mvn1.model.LoginRequestDTO;
import com.example.mvn1.model.LoginResponseDTO;
import com.example.mvn1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController{

    @Autowired
    UserService userService;

//    private final PasswordEncoder passwordEncoder;
//    private final AuthenticationManager authenticationManager;
//    private final Environment env;

    @GetMapping("/salary")
    public String getSalary() {
//        userRepository.save(user);
//        User user = new User();
//        user.setUserName("hw");
//        user.setRoles("ADMIN");
//        user.setPassword("123");
//        user.setActive(true);
//        userService.saveUser(user);
        return "salary";
    }

    @PostMapping("/signup")
    public User postUser(@RequestBody User user) {


        return userService.saveUser(user);
    }

    @GetMapping("/login")
    public String login() {


        return "jwt is ";
    }

//    @PostMapping("/apiLogin")
//    public ResponseEntity<LoginResponseDTO> apiLogin (@RequestBody LoginRequestDTO loginRequest) {
//        String jwt = "";
//        Authentication authentication = UsernamePasswordAuthenticationToken.unauthenticated(loginRequest.username(),
//                loginRequest.password());
//        Authentication authenticationResponse = authenticationManager.authenticate(authentication);
//        if(null != authenticationResponse && authenticationResponse.isAuthenticated()) {
//            if (null != env) {
//                String secret = env.getProperty(ApplicationConstants.JWT_SECRET_KEY,
//                        ApplicationConstants.JWT_SECRET_DEFAULT_VALUE);
//                SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
//                jwt = Jwts.builder().issuer("Eazy Bank").subject("JWT Token")
//                        .claim("username", authenticationResponse.getName())
//                        .claim("authorities", authenticationResponse.getAuthorities().stream().map(
//                                GrantedAuthority::getAuthority).collect(Collectors.joining(",")))
//                        .issuedAt(new java.util.Date())
//                        .expiration(new java.util.Date((new java.util.Date()).getTime() + 30000000))
//                        .signWith(secretKey).compact();
//            }
//        }
//        return ResponseEntity.status(HttpStatus.OK).header(ApplicationConstants.JWT_HEADER,jwt)
//                .body(new LoginResponseDTO(HttpStatus.OK.getReasonPhrase(), jwt));
//    }
}

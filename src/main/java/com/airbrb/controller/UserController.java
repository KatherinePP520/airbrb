package com.airbrb.controller;


import com.airbrb.domain.Token;
import com.airbrb.domain.User;
import com.airbrb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/auth/register")
    public ResponseEntity  register(@RequestBody User user) {
        Token token = userService.register(user);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(APPLICATION_JSON)
                .body(token);

    }

    @PostMapping("/auth/login")
    public ResponseEntity login(@RequestBody User user ) {
        Token token = userService.login(user);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(APPLICATION_JSON)
                .body(token);
    }
    @PostMapping("/auth/logout")
    public ResponseEntity logout(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        userService.logout(token);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(APPLICATION_JSON)
                .body(new Result());
    }
}

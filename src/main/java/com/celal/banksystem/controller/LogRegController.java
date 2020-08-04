package com.celal.banksystem.controller;

import com.celal.banksystem.libs.response.LoginResponse;
import com.celal.banksystem.libs.response.RegisterResponse;
import com.celal.banksystem.service.LogRegService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LogRegController {

    private final LogRegService service;

    @PostMapping("/login")
    public LoginResponse postLogin(@RequestParam("email") String email, @RequestParam("password") String password) {
        return service.login(email, password, true)
                .map(t -> new LoginResponse(t, email, password))
                .orElse(new LoginResponse("null", "null", "null"));
    }


    @PostMapping("/register")
    public RegisterResponse register(@RequestParam("email") String email,
                                     @RequestParam("password") String password) {
        if (service.register(email, password)) {
            return service.login(email, password, true)
                    .map(token -> new RegisterResponse(email, password, token))
                    .orElse(new RegisterResponse("null", "null", "null"));
        }
        return new RegisterResponse("null", "null", "null");
    }
}

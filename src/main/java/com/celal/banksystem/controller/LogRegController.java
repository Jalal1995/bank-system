package com.celal.banksystem.controller;

import com.celal.banksystem.libs.request.UserRequest;
import com.celal.banksystem.libs.response.LoginResponse;
import com.celal.banksystem.libs.response.RegisterResponse;
import com.celal.banksystem.service.LogRegService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LogRegController {

    private final LogRegService service;

    @PostMapping("/login")
    public LoginResponse postLogin(@RequestBody UserRequest user) {
        return service.login(user.getEmail(), user.getPassword(), true)
                .map(t -> new LoginResponse(t, user.getEmail(), user.getPassword()))
                .orElse(new LoginResponse("null", "null", "null"));
    }


    @PostMapping("/register")
    public RegisterResponse register(@RequestBody UserRequest user) {
        if (service.register(user.getEmail(), user.getPassword())) {
            return service.login(user.getEmail(), user.getPassword(), true)
                    .map(token -> new RegisterResponse(user.getEmail(), user.getPassword(), token))
                    .orElse(new RegisterResponse("null", "null", "null"));
        }
        return new RegisterResponse("null", "null", "null");
    }
}

package com.celal.banksystem.controller;

import com.celal.banksystem.libs.entity.Credit;
import com.celal.banksystem.libs.entity.Customer;
import com.celal.banksystem.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Log4j2
public class ApiController {

    private final CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        List<Customer> customers = customerService.findAll();
        customers.forEach(log::info);
        customers.forEach(c -> {
            for (Credit cr : c.getCredits()) {
                log.info(cr);
            }
        });
        return ResponseEntity.ok().body(customers);
    }

}

package com.celal.banksystem.controller;

import com.celal.banksystem.libs.entity.Customer;
import com.celal.banksystem.libs.response.Confirmation;
import com.celal.banksystem.libs.response.CustomerResponse;
import com.celal.banksystem.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Log4j2
public class ApiController {

    private final CustomerService customerService;
    private final ModelMapper mapper;

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerResponse>> getAllCustomer() {
        List<CustomerResponse> returnValue;
        List<Customer> customers = customerService.findAll();
        Type listType = new TypeToken<List<CustomerResponse>>() {
        }.getType();
        returnValue = mapper.map(customers, listType);
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<>(returnValue, responseHeaders, HttpStatus.OK);
    }

    @PostMapping("/customers")
    public ResponseEntity<List<CustomerResponse>> getAllCustomersByDetails(@RequestParam Integer amount) {
        List<CustomerResponse> returnValue;
        List<Customer> customers = customerService.findCustomersByDetails(amount);
        Type listType = new TypeToken<List<CustomerResponse>>() {
        }.getType();
        returnValue = mapper.map(customers, listType);
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<>(returnValue, responseHeaders, HttpStatus.OK);
    }

    @GetMapping("/confirmations")
    public ResponseEntity<Confirmation> getConfirmation(@RequestParam Integer amount) {
        List<Customer> customers = customerService.findCustomersByDetails(amount);
        HttpHeaders responseHeaders = new HttpHeaders();
        Confirmation confirmation = Confirmation.builder()
                .customers(customers)
                .text("confirmation text")
                .amount(amount)
                .methodOfSending("email")
                .build();
        return new ResponseEntity<>(confirmation, responseHeaders, HttpStatus.OK);
    }
}

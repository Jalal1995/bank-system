package com.celal.banksystem.service;

import com.celal.banksystem.libs.entity.Customer;
import com.celal.banksystem.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public List<Customer> findCustomersByDetails(Integer amount) {
        return customerRepository.findCustomersByDetails(amount);
    }
}

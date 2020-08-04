package com.celal.banksystem.utils;

import com.celal.banksystem.libs.entity.Credit;
import com.celal.banksystem.libs.entity.Customer;
import com.celal.banksystem.libs.entity.User;
import com.celal.banksystem.repositories.CreditRepository;
import com.celal.banksystem.repositories.CustomerRepository;
import com.celal.banksystem.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;


@Log4j2
@Configuration
@Transactional
@RequiredArgsConstructor
public class AutoRun {

    private final PasswordEncoder encoder;
    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final CreditRepository creditRepository;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Bean
    public CommandLineRunner autorun() {
        return (String... args) -> {
            User user = new User("test", encoder.encode("test"));
            userRepository.save(user);
            Customer customer = Customer.builder()
                    .name("cust1")
                    .maxLoanAmount(300)
                    .build();
            Customer customer2 = Customer.builder()
                    .name("cust2")
                    .maxLoanAmount(400)
                    .build();
            Credit credit1 = Credit.builder()
                    .amount(500)
                    .paidAmount(400)
                    .date(convertToDate("2020-01-01"))
                    .paidDate(convertToDate("2019-12-12"))
                    .build();
            Credit credit2 = Credit.builder()
                    .amount(600)
                    .paidAmount(600)
                    .date(convertToDate("2020-02-02"))
                    .paidDate(convertToDate("2019-01-01"))
                    .build();
            Credit credit3 = Credit.builder()
                    .amount(700)
                    .paidAmount(600)
                    .date(convertToDate("2020-01-01"))
                    .paidDate(convertToDate("2019-12-12"))
                    .build();
            Credit credit4 = Credit.builder()
                    .amount(800)
                    .paidAmount(800)
                    .date(convertToDate("2020-02-02"))
                    .paidDate(convertToDate("2019-01-01"))
                    .build();
            List<Credit> cus1Credits = Arrays.asList(
                    credit1,
                    credit2
            );
            List<Credit> cus2Credits = Arrays.asList(
                    credit3,
                    credit4
            );
            customer.setCredits(cus1Credits);
            customer2.setCredits(cus2Credits);
            credit1.setCustomer(customer);
            credit2.setCustomer(customer);
            credit3.setCustomer(customer2);
            credit4.setCustomer(customer2);
            customerRepository.save(customer);
            customerRepository.save(customer2);

        };
    }

    public LocalDate convertToDate(String s) {
        return LocalDate.parse(s, formatter);
    }
}

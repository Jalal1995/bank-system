package com.celal.banksystem.libs.response;

import com.celal.banksystem.libs.entity.Customer;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Confirmation {
    private Integer amount;
    private String text;
    private String methodOfSending;
    private List<Customer> customers;
}

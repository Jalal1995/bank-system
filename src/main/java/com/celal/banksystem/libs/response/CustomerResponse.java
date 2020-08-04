package com.celal.banksystem.libs.response;

import com.celal.banksystem.libs.entity.Credit;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerResponse {
    private String name;
    private Integer maxLoanAmount;
    private List<Credit> credits;
}

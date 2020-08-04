package com.celal.banksystem.repositories;

import com.celal.banksystem.libs.entity.Customer;
import com.celal.banksystem.libs.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c WHERE c.maxLoanAmount > :amount")
    List<Customer> findCustomersByDetails(Integer amount);
}

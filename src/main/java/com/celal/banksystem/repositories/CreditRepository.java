package com.celal.banksystem.repositories;

import com.celal.banksystem.libs.entity.Credit;
import com.celal.banksystem.libs.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {

}

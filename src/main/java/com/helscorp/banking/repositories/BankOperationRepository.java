package com.helscorp.banking.repositories;

import com.helscorp.banking.model.BankOperation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankOperationRepository extends JpaRepository<BankOperation,Integer> {
}

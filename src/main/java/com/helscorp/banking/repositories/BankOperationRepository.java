package com.helscorp.banking.repositories;

import com.helscorp.banking.dto.BankOperationDto;
import com.helscorp.banking.model.BankOperation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankOperationRepository extends JpaRepository<BankOperation,Integer> {
    List<BankOperation> findAllByUserId(Integer userId);
}

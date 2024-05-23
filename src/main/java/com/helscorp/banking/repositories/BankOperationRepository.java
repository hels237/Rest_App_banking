package com.helscorp.banking.repositories;

import com.helscorp.banking.dto.BankOperationDto;
import com.helscorp.banking.model.BankOperation;
import com.helscorp.banking.model.OperationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface BankOperationRepository extends JpaRepository<BankOperation,Integer> {

    List<BankOperation> findAllByUserId(Integer userId);


    @Query("select sum(b.amount) from BankOperation b where b.user.id = :userId")
    BigDecimal findAccountBalance(Integer userId);


    @Query("select max(abs(b.amount)) from BankOperation b where b.user.is = :userId and b.type = :type")
    BigDecimal findHighestTransferAmount(Integer userId, OperationType type);

    @Query("select b.createdDate, sum(b.amount) from BankOperation b where b.user.id = :userId and b.createdDate between :start and :end")
    Map<LocalDate, BigDecimal> findSumBankOperationByDate(LocalDateTime start, LocalDateTime end, Integer userId);
}

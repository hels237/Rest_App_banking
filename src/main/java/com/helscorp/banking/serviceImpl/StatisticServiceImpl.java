package com.helscorp.banking.serviceImpl;

import com.helscorp.banking.model.OperationType;
import com.helscorp.banking.repositories.BankOperationRepository;
import com.helscorp.banking.service.StatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StatisticServiceImpl implements StatisticService {

    private final BankOperationRepository transactionRepository;


    @Override
    public Map<LocalDate, BigDecimal> findSumBankOperationByDate(LocalDate startDate, LocalDate endDate, Integer userId) {

        //LocalDateTime.of(LocalDate , LocalTime.of(hour,minute,second))
        LocalDateTime start = LocalDateTime.of(startDate, LocalTime.of(0,0,0));
        LocalDateTime end = LocalDateTime.of(endDate, LocalTime.of(23,59,59));

        return transactionRepository.findSumBankOperationByDate(start,end,userId);
    }

    @Override
    public BigDecimal geAccountBalance(Integer userId) {
        return transactionRepository.findAccountBalance(userId);
    }

    @Override
    public BigDecimal highestTransfer(Integer userId) {
        return transactionRepository.findHighestTransferAmount(userId, OperationType.TRANSFER);
    }

    @Override
    public BigDecimal highestDeposit(Integer userId) {
        return transactionRepository.findHighestTransferAmount(userId, OperationType.DEPOSIT);
    }


}

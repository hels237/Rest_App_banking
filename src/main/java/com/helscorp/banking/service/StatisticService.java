package com.helscorp.banking.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

public interface StatisticService {

    Map<LocalDate, BigDecimal> findSumBankOperationByDate(LocalDate startDate , LocalDate endDate,Integer userId);

    BigDecimal geAccountBalance(Integer userId);

    BigDecimal highestTransfer(Integer userId);

    BigDecimal highestDeposit(Integer userId);
}

package com.helscorp.banking.controllers;


import com.helscorp.banking.service.StatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;


@RestController
@RequestMapping("/statistics")
@RequiredArgsConstructor
public class StatisticController {

    private final StatisticService statisticService;

    @GetMapping("/find-sum-by-data/{user-id}")
    public ResponseEntity<Map<LocalDate, BigDecimal>> findSumBankOperationByDate
            (@PathVariable Integer userId,
             @RequestParam LocalDate startDate ,
             @RequestParam LocalDate endDate)
    {

        return ResponseEntity.ok(statisticService.findSumBankOperationByDate(startDate,endDate,userId));

    }

    @GetMapping("/account-balance/{user-id}")
    public ResponseEntity<BigDecimal> geAccountBalance(@PathVariable("user-id") Integer userId){
        return  ResponseEntity.ok(statisticService.geAccountBalance(userId));
    }

    @GetMapping("highest-transfer/{user-id}")
    ResponseEntity<BigDecimal> highestTransfer(Integer userId){
        return  ResponseEntity.ok(statisticService.highestTransfer(userId));
    }

    @GetMapping("/highest-deposit/{user-id}")
     public ResponseEntity<BigDecimal> highestDeposit(Integer userId){

        return ResponseEntity.ok(statisticService.highestDeposit(userId));
     }

}

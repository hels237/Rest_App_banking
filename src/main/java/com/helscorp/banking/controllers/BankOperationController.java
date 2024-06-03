package com.helscorp.banking.controllers;


import com.helscorp.banking.dto.BankOperationDto;
import com.helscorp.banking.service.BankOperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class BankOperationController {

    private final BankOperationService bankOperationService;

    @PostMapping("/")
    public ResponseEntity<Integer> save(@RequestBody BankOperationDto bankOperationDto){
        return ResponseEntity.ok(bankOperationService.save(bankOperationDto));
    }

    @GetMapping("/{bankOperation-id}")
    public ResponseEntity<BankOperationDto> findById(@PathVariable("bankOperation-id") Integer id){
        return ResponseEntity.ok(bankOperationService.findById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<BankOperationDto>> findAll(){
        return ResponseEntity.ok(bankOperationService.findAll());
    }

    @GetMapping("/user/{user-id}")
    public ResponseEntity<List<BankOperationDto>> findAllByUserId(@PathVariable("user-id") Integer userId){
        return ResponseEntity.ok(bankOperationService.findAllByUserId(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("bankOperation-id") Integer id){
        bankOperationService.delete(id);
        return  ResponseEntity.accepted().build();
    }


}

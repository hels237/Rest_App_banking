package com.helscorp.banking.controllers;

import com.helscorp.banking.dto.AccountDto;
import com.helscorp.banking.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/")
    public ResponseEntity<Integer> save(@RequestBody AccountDto accountDto){
        return ResponseEntity.ok(accountService.save(accountDto));
    }

    @GetMapping("/{account-id}")
    public ResponseEntity<AccountDto> findById(@PathVariable("account-id")  Integer accountId){
        return ResponseEntity.ok(accountService.findById(accountId));
    }

    @GetMapping("/")
    public ResponseEntity<List<AccountDto>> findAll(){
        return ResponseEntity.ok(accountService.findAll());
    }

    @DeleteMapping("/")
    public ResponseEntity<Void> delete(@PathVariable("account-id") Integer accountId){
        accountService.delete(accountId);
        return ResponseEntity.accepted().build();

    }

}

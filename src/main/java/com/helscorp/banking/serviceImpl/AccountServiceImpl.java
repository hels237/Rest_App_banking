package com.helscorp.banking.serviceImpl;

import com.helscorp.banking.dto.AccountDto;
import com.helscorp.banking.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {



    @Override
    public Integer save(AccountDto object) {
        return 0;
    }

    @Override
    public List<AccountDto> findAll() {
        return List.of();
    }

    @Override
    public AccountDto findById(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}

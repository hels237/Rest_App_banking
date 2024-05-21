package com.helscorp.banking.service;

import com.helscorp.banking.dto.BankOperationDto;

import java.util.List;

public interface BankOperationService extends AbstractService<BankOperationDto> {
     List<BankOperationDto> findAllByUserId(Integer userId);

}

package com.helscorp.banking.serviceImpl;

import com.helscorp.banking.dto.BankOperationDto;
import com.helscorp.banking.exceptions.InvalidOperationException;
import com.helscorp.banking.model.BankOperation;
import com.helscorp.banking.model.Contact;
import com.helscorp.banking.model.OperationType;
import com.helscorp.banking.repositories.BankOperationRepository;
import com.helscorp.banking.service.BankOperationService;
import com.helscorp.banking.validators.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BankOperationServiceImpl implements BankOperationService {

    private final BankOperationRepository bankOperationRepository;

    private final ObjectsValidator<BankOperationDto> validator;


    @Override
    public Integer save(BankOperationDto dto) {
        // validate dto
        validator.validate(dto);

        //map dto to entity
        BankOperation bankOperation = BankOperationDto.toEntity(dto);

        // recalculate the amount of transactionby the bankOptype()
        BigDecimal amount = bankOperation.getAmount().multiply(BigDecimal.valueOf(getBankOperationType(bankOperation.getType())));

        //set the new amount
        bankOperation.setAmount(amount);

        return bankOperationRepository.save(bankOperation).getId();
    }

    @Override
    public List<BankOperationDto> findAll() {
        return bankOperationRepository.findAll().stream().map(BankOperationDto::fromEntity).toList();
    }

    @Override
    public BankOperationDto findById(Integer id) {

        return bankOperationRepository
                .findById(id).map(BankOperationDto::fromEntity)
                .orElseThrow(
                        ()-> new EntityNotFoundException(" bankOperation not found for the ID : "+id)
                );

    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            throw new InvalidOperationException(" ID is null "," ID null ", BankOperation.class.getName());
        }
        bankOperationRepository.deleteById(id);
    }


    /******************************************** convenient methods ***********************************/

    private int getBankOperationType(OperationType type){
        return OperationType.TRANSFER == type ? -1 : 1;
    }
}

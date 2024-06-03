package com.helscorp.banking.serviceImpl;

import com.helscorp.banking.dto.AccountDto;
import com.helscorp.banking.dto.UserDto;
import com.helscorp.banking.exceptions.InvalidOperationException;
import com.helscorp.banking.model.Account;
import com.helscorp.banking.model.User;
import com.helscorp.banking.repositories.AccountRepository;
import com.helscorp.banking.repositories.UserRepository;
import com.helscorp.banking.service.AccountService;
import com.helscorp.banking.service.UserService;
import com.helscorp.banking.validators.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;


    private final ObjectsValidator<AccountDto> validator;

    @Override
    public Integer save(AccountDto dto) {

        // validate the object
        validator.validate(dto);

        // convert accountDto to account entity
        Account account = AccountDto.toEntity(dto);

        // check if account already exist
        boolean isAccountUserAlreadyExist = accountRepository.findByUserId(account.getUser().getId()).isPresent();

        if(isAccountUserAlreadyExist){
            throw  new InvalidOperationException("Account already exist ","can't create new Account",Account.class.getName());
        }



        if(dto.getId() == null){

            //generate random IBAN
            account.setIban(generateRandomIban());
        }

        return accountRepository.save(account).getId();

    }


    @Override
    public List<AccountDto> findAll() {

        return accountRepository.findAll().stream().map(AccountDto::fromEntity).toList();
    }

    @Override
    public AccountDto findById(Integer id) {
        return accountRepository.findById(id).map(AccountDto::fromEntity).orElseThrow(()->new EntityNotFoundException(" Account not found with the is"+id));
    }

    @Override
    public void delete(Integer id) {
        accountRepository.deleteById(id);
    }



// -------------------------------------------------- method for generating IBAN ----------------------------------------------------*/

    private String generateRandomIban(){

        //generate an iban
        String iban = Iban.random(CountryCode.DE).toFormattedString();

        // check if the iban already exist
        boolean ibanExist = accountRepository.findByIban(iban).isPresent();

        //if exist -> generate a new iban
        if(ibanExist){
            generateRandomIban();
        }

        // if not exist return the generate iban iban
        return iban;
    }

}

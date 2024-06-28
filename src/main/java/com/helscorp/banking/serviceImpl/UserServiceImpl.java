package com.helscorp.banking.serviceImpl;

import com.helscorp.banking.dto.AccountDto;
import com.helscorp.banking.dto.UserDto;
import com.helscorp.banking.model.User;
import com.helscorp.banking.repositories.AccountRepository;
import com.helscorp.banking.repositories.UserRepository;
import com.helscorp.banking.service.AccountService;
import com.helscorp.banking.service.UserService;
import com.helscorp.banking.validators.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    private final ObjectsValidator<UserDto> validator;

    private final AccountService accountService;


    @Override
    public Integer save(UserDto userDto) {

        validator.validate(userDto);

        User user = UserDto.toEntity(userDto);

        return repository.save(user).getId();
    }


    @Override
    public List<UserDto> findAll() {

        // a stream is a sequence of elements that allows for processing operations.
        List<UserDto> theDto = repository.findAll().stream().map(UserDto::fromEntity).toList();

        return theDto;//create immutable objects
    }


    @Override
    public UserDto findById(Integer id) {

        return repository
                        .findById(id)
                        .map(UserDto::fromEntity)
                        .orElseThrow(()-> new EntityNotFoundException("user not found with the id provided : "+id));
    }


    @Override
    public void delete(Integer id) {
        if(id == null){
            return;
        }
        repository.deleteById(id);
    }



    @Override
    public Integer validateUserAccount(Integer id) {

        //validate user
        User user = repository.findById(id)
                .orElseThrow(
                        ()-> new EntityNotFoundException("user not found to validate with id : "+id)
                );

        //create an account for the user
        AccountDto accountDto = AccountDto.builder().userDto(UserDto.fromEntity(user)).build();

        accountService.save(accountDto);

        //activate user account
        user.setAccountIsActive(true);
        repository.save(user);

        return user.getId() ;

    }



/*    public Integer validateUserAccount2(Integer id){

        User user = repository.findById(id).orElseThrow(()-> new EntityNotFoundException("user not found with the Id : "+id));



    }*/



    @Override
    public Integer invalidateUseAccount(Integer id) {

        User user = repository.findById(id).orElseThrow(()-> new EntityNotFoundException("user not found to validate with id : "+id));
        // enable user account
        user.setAccountIsActive(false);

        repository.save(user);

        return user.getId();
    }
}

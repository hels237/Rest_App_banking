package com.helscorp.banking.serviceImpl;

import com.helscorp.banking.dto.UserDto;
import com.helscorp.banking.model.User;
import com.helscorp.banking.repositories.UserRepository;
import com.helscorp.banking.service.UserService;
import com.helscorp.banking.validators.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    private final ObjectsValidator<UserDto> validator;


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



}

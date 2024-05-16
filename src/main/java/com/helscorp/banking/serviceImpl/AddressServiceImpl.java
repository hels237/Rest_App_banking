package com.helscorp.banking.serviceImpl;

import com.helscorp.banking.dto.AddressDto;
import com.helscorp.banking.exceptions.InvalidOperationException;
import com.helscorp.banking.model.Address;
import com.helscorp.banking.repositories.AddressRepository;
import com.helscorp.banking.service.AddressService;
import com.helscorp.banking.validators.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {


    private final AddressRepository addressRepository;

    private final ObjectsValidator<AddressDto> validator;


    @Override
    public Integer save(AddressDto dto) {

        //validate the dto
        validator.validate(dto);

        Address address = AddressDto.toEntity(dto);

        return  addressRepository.save(address).getId();
    }


    @Override
    public List<AddressDto> findAll() {
        return addressRepository.findAll().stream().map(AddressDto::fromEntity).toList();
    }

    @Override
    public AddressDto findById(Integer id) {

        return addressRepository
                .findById(id)
                .map(AddressDto::fromEntity).orElseThrow(
                        ()-> new EntityNotFoundException("not found Address entity for id : "+id)
                );
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            throw new InvalidOperationException("invalid id"," id Null",Address.class.getName());
        }
        addressRepository.findById(id);

    }
}

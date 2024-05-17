package com.helscorp.banking.serviceImpl;

import com.helscorp.banking.dto.ContactDto;
import com.helscorp.banking.exceptions.InvalidOperationException;
import com.helscorp.banking.model.Contact;
import com.helscorp.banking.repositories.ContactRepository;
import com.helscorp.banking.service.ContactService;
import com.helscorp.banking.validators.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    private final ObjectsValidator<ContactDto> validator;


    @Override
    public Integer save(ContactDto dto) {

        //validate dto
        validator.validate(dto);

        //map  dto to entity
        Contact contact = ContactDto.toEntity(dto);

        return contactRepository.save(contact).getId();
    }

    @Override
    public List<ContactDto> findAll() {
        return contactRepository.findAll().stream().map(ContactDto::fromEntity).toList();
    }

    @Override
    public ContactDto findById(Integer id) {
        if(id == null){
            return null;
        }

        return contactRepository
                .findById(id)
                .map(ContactDto::fromEntity)
                .orElseThrow(
                        ()-> new EntityNotFoundException("contact not found for the ID : "+id)
                );
    }


    @Override
    public void delete(Integer id) {
        if(id ==  null){
            throw new InvalidOperationException(" ID not provided or null "," ID null ",Contact.class.getName());
        }
        contactRepository.deleteById(id);

    }
}

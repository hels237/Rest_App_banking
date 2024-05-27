package com.helscorp.banking.controllers;


import com.helscorp.banking.dto.ContactDto;
import com.helscorp.banking.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @PostMapping("/")
    public ResponseEntity<Integer> save(@RequestBody ContactDto contactDto){
        return  ResponseEntity.ok(contactService.save(contactDto));
    }

    @GetMapping("/{contact-id}")
    public ResponseEntity<ContactDto> findById(@PathVariable("contact-id") Integer contactId){
        return ResponseEntity.ok(contactService.findById(contactId));
    }

    @GetMapping("/")
    public ResponseEntity<List<ContactDto>> findAll(){
        return ResponseEntity.ok(contactService.findAll());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ContactDto>> findAllByUserId(@PathVariable Integer userId){
        return ResponseEntity.ok(contactService.findAllByUserId(userId));
    }


    public ResponseEntity<Void> delete(@PathVariable("contact-id") Integer contactId){
        contactService.delete(contactId);
        return ResponseEntity.accepted().build();
    }
}

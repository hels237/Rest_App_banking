package com.helscorp.banking.controllers;


import com.helscorp.banking.dto.ContactDto;
import com.helscorp.banking.service.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "contact management",description = " create,read,update and delete the contact")
@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @PostMapping("/")
    public ResponseEntity<Integer> save(@RequestBody ContactDto contactDto){
        return  ResponseEntity.ok(contactService.save(contactDto));
    }

    @Operation(summary = "get the contact by id",description = "return a specific contact ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description="successfully retrieve"),
            @ApiResponse(responseCode = "404",description="contact not found")
    })
    @GetMapping("/{contact-id}")
    public ResponseEntity<ContactDto> findById( @Parameter(name = "contact-id",description = "provide the id of the contact")
                                                    @PathVariable("contact-id") Integer contactId ){
        return ResponseEntity.ok(contactService.findById(contactId));
    }

    @GetMapping("/")
    public ResponseEntity<List<ContactDto>> findAll(){
        return ResponseEntity.ok(contactService.findAll());
    }

    @Operation(summary = " get all contacts of the user",description = "retrieve all the contacts of a specific user id")
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ContactDto>> findAllByUserId(@PathVariable Integer userId){
        return ResponseEntity.ok(contactService.findAllByUserId(userId));
    }

    @Operation(summary = " delete the contact",description = "remove  a specific contact")
    @DeleteMapping("/{contact-id}")
    public ResponseEntity<Void> delete(@PathVariable("contact-id") Integer contactId){
        contactService.delete(contactId);
        return ResponseEntity.accepted().build();
    }
}

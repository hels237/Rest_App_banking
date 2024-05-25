package com.helscorp.banking.controllers;


import com.helscorp.banking.dto.AddressDto;
import com.helscorp.banking.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sddresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;


    @PostMapping("/")
    public ResponseEntity<Integer> save(@RequestBody AddressDto addressDto){
        return ResponseEntity.ok(addressService.save(addressDto));
    }

    @GetMapping("/{address-id}")
    public ResponseEntity<AddressDto> findById(@PathVariable("address-id") Integer id){
        return ResponseEntity.ok(addressService.findById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<AddressDto>> findAll(){
        return ResponseEntity.ok(addressService.findAll());
    }

    @DeleteMapping("/{address-id")
    public ResponseEntity<Void> delete(@PathVariable("address-id") Integer id){
        addressService.delete(id);
        return ResponseEntity.accepted().build();
    }
}

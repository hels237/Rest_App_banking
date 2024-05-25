package com.helscorp.banking.controllers;


import com.helscorp.banking.dto.UserDto;
import com.helscorp.banking.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService  userService;


    @PostMapping("/")
    public ResponseEntity<Integer> save(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.save(userDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{user-id}")
    public ResponseEntity<UserDto> findById(@PathVariable("user-id") Integer userId){
        return ResponseEntity.ok(userService.findById(userId));
    }

    @PatchMapping("/validate/{user-id}")
    public ResponseEntity<Integer> validateAccount(@PathVariable("user-id") Integer userId){
        return ResponseEntity.ok(userService.validateUserAccount(userId));
    }

    @PatchMapping("/invalidate/{user-id}")
    public ResponseEntity<Integer> invalidateAccount(@PathVariable("user-id") Integer userId){
        return ResponseEntity.ok(userService.invalidateUseAccount(userId));
    }

    public ResponseEntity<Void> delete(@PathVariable("user-id") Integer userId){
        return ResponseEntity.accepted().build();
    }


}

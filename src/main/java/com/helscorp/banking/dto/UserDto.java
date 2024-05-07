package com.helscorp.banking.dto;


import com.helscorp.banking.model.User;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDto {

    @NotNull
    @NotEmpty
    @NotBlank
    private String firstName;

    @NotNull
    @NotEmpty
    @NotBlank
    private String lastName;

    @NotNull
    @NotEmpty
    @NotBlank
    @Email
    private String email;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 8,max = 16)
    private String password;


    public static UserDto fromEntity(User user){

        if(user == null){
            return null;
            //todo throw an exception
        }
        return  UserDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }


    public static User toEntity(UserDto userDto){

        if(userDto == null){
            return null;
            //todo throw an exception
        }
        return User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .build();
    }
}

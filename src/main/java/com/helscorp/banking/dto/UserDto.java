package com.helscorp.banking.dto;


import com.helscorp.banking.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDto {

    private Integer id;

    @NotNull(message = "the firstname can't be null")
    @NotEmpty(message = " the firstname can't be empty")
    private String firstName;

    @NotNull(message = "the lastname can't be null")
    @NotEmpty(message = "the lastname can't be empty")
    private String lastName;

    @NotNull(message = "the email can't be null")
    @NotEmpty(message = "the email can't be null")
    @Email
    private String email;

    @NotNull(message = "password can't be null")
    @NotEmpty(message = "password can't be empty")
    @Size(min = 6,max = 16,message = "password must be between 6 and 16")
    private String password;


    public static UserDto fromEntity(User user){

        if(user == null){
            return null;
            //todo throw an exception
        }
        return  UserDto.builder()
                .id(user.getId())
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
                .id(userDto.getId())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .build();
    }


}

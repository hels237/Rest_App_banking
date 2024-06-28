package com.helscorp.banking.dto;


import com.helscorp.banking.model.Account;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountDto {
    @Schema(name = "id",example = " id = 1")
    private Integer id;


    private String iban ;


    private UserDto userDto;




    public static AccountDto fromEntity(Account account){

        if(account == null){
            return  null;
            //todo throw an exception
        }
        return AccountDto
                .builder()
                .iban(account.getIban())
                .userDto(UserDto.fromEntity(account.getUser()))
                .build();
    }

    public static Account toEntity(AccountDto accountDto){

        if(accountDto == null){
            return  null;
            //todo throw an exception
        }
        return Account
                .builder()
                .iban(accountDto.getIban())
                .user(UserDto.toEntity(accountDto.getUserDto()))
                .build();
    }

}

package com.helscorp.banking.dto;


import com.helscorp.banking.model.Account;
import com.helscorp.banking.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountDto {
    @NotNull
    @NotEmpty
    @NotBlank
    private String iban ;

    @NotNull
    @NotEmpty
    @NotBlank
    private UserDto user ;

    public static AccountDto fromEntity(Account account){

        if(account == null){
            return  null;
            //todo throw an exception
        }
        return AccountDto
                .builder()
                .iban(account.getIban())
                .user(UserDto.fromEntity(account.getUser()))
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
                .user(UserDto.toEntity(accountDto.getUser()))
                .build();
    }
}

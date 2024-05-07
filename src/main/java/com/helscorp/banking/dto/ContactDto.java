package com.helscorp.banking.dto;


import com.helscorp.banking.model.Contact;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContactDto {
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
    private String iban ;



    public static ContactDto fromEntity(Contact contact){
        if(contact == null){
            return null;
            //todo thrown an exception
        }
        return ContactDto
                .builder()
                .firstName(contact.getFirstName())
                .lastName(contact.getLastName())
                .email(contact.getEmail())
                .iban(contact.getIban())
                .build();
    }

    public static Contact toEntity(ContactDto contactDto){
        if(contactDto == null){
            return null;
            //todo thrown an exception
        }
        return Contact
                .builder()
                .firstName(contactDto.getFirstName())
                .lastName(contactDto.getLastName())
                .email(contactDto.getEmail())
                .iban(contactDto.getIban())
                .build();
    }

}

package com.helscorp.banking.dto;


import com.helscorp.banking.model.Address;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDto {

    @NotNull
    @NotEmpty
    @NotBlank
    private String street ;

    @NotNull
    @NotEmpty
    @NotBlank
    private Integer houseNumber ;

    private Integer postalCode ;

    @NotNull
    @NotEmpty
    @NotBlank
    private String city ;

    @NotNull
    @NotEmpty
    @NotBlank
    private String country ;

    public static AddressDto fromEntity(Address address){

        if(address == null){
            return null;
            //todo thrown exception
        }
        return  AddressDto
                .builder()
                .street(address.getStreet())
                .houseNumber(address.getHouseNumber())
                .city(address.getCity())
                .country(address.getCountry())
                .postalCode(address.getPostalCode())
                .build();
    }


    public static Address toEntity(AddressDto addressDto){

        if(addressDto == null){
            return null;
            //todo thrown exception
        }
        return  Address
                .builder()
                .street(addressDto.getStreet())
                .houseNumber(addressDto.getHouseNumber())
                .city(addressDto.getCity())
                .country(addressDto.getCountry())
                .postalCode(addressDto.getPostalCode())
                .build();
    }


}

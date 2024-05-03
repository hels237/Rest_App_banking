package com.helscorp.banking.dto;


import com.helscorp.banking.model.Address;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDto {

    private String street ;

    private Integer houseNumber ;

    private Integer postalCode ;

    private String city ;

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

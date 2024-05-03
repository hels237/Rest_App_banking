package com.helscorp.banking.dto;


import com.helscorp.banking.model.Role;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class RoleDto {

    private String name ;

    private  UserDto user;




    public static RoleDto  fromEntity(Role role){
        if(role == null){
            return  null;
            //todo throw an exception
        }
        return RoleDto.builder()
                .name(role.getName())
                .user(UserDto.fromEntity(role.getUser()))
                .build();
    }

    public static Role toEntity(RoleDto roleDto){
        if(roleDto == null){
            return null;
            //todo throw an exception
        }
        return Role.builder()
                .name(roleDto.getName())
                .user(UserDto.toEntity(roleDto.getUser()))
                .build();
    }


}

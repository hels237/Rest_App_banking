package com.helscorp.banking.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;



@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "_user")
public class User extends AbstractEntity{

    private String firstName;


    private String lastName;


    //@Column(unique = true)
    private String email;

    private String password;

    private boolean accountIsActive ;

    @OneToOne(mappedBy = "user")
    private Address address;

    @OneToMany(mappedBy = "user")
    private List<BankOperation> bankOperationList;

    @OneToMany(mappedBy = "user")
    private List<Contact> contactList;

    @OneToOne(mappedBy = "user")
    private Role role ;

    @OneToOne(mappedBy = "user")
    private Account account ;



}

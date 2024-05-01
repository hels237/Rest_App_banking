package com.helscorp.banking.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contact")
public class Contact extends AbstractEntity{

    private String firstName;

    private String lastName;

    private String email;

    private String iban ;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user ;
}

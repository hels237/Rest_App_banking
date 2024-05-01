package com.helscorp.banking.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


@AllArgsConstructor
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address extends AbstractEntity {

    private String street ;

    private Integer houseNumber ;

    private Integer postalCode ;

    private String city ;

    private String country ;

    @OneToOne
    @JoinColumn(name = "id_user")
    private User user ;
}

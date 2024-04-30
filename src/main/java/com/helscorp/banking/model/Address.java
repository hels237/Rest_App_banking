package com.helscorp.banking.model;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "Address")
public class Address {

    private Integer id ;

    private String street ;

    private Integer houseNumber ;

    private Integer postalCode ;

    private String city ;

    private String country ;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user ;
}

package com.helscorp.banking.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;


@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account")
public class Account extends AbstractEntity{

    private String iban ;

    @OneToOne
    @JoinColumn(name = "id_user")
    private User user ;


}

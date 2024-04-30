package com.helscorp.banking.model;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Account")
public class Account {

    private Integer id ;

    private String iban ;

    private LocalDateTime creationDate ;

    private LocalDateTime lstUpdate ;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user ;


}

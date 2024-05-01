package com.helscorp.banking.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bank_operation")
public class BankOperation extends  AbstractEntity{

    private BigDecimal amount ;

    @Enumerated(EnumType.STRING)
    private OperationType type ;

    private String destinationIban ;

    private LocalDateTime creationDate ;

    private LocalDateTime lastUpdate ;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;


}

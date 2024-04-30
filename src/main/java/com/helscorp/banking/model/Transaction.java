package com.helscorp.banking.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Transaction")
public class Transaction {

    private Integer id ;

    private BigDecimal amount ;

    @Enumerated(EnumType.STRING)
    private TransactionType type ;

    private String destinationIban ;

    private LocalDateTime creationDate ;

    private LocalDateTime lastUpdate ;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}

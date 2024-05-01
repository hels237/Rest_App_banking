package com.helscorp.banking.model;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;


@Data
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
public class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    private LocalDateTime creationDate ;

    private LocalDateTime lastUpdate;

}

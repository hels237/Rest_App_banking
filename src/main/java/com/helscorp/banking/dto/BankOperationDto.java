package com.helscorp.banking.dto;


import com.helscorp.banking.model.BankOperation;
import com.helscorp.banking.model.OperationType;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class BankOperationDto {

    @Positive
    private BigDecimal amount ;

    private OperationType type ;

    private String destinationIban ;

    private LocalDateTime creationDate ;

    private LocalDateTime lastUpdate ;




    public static BankOperationDto fromEntity(BankOperation bankOperation){

        if(bankOperation == null){
            return null;
            //todo throw an exception
        }
        return BankOperationDto
                .builder()
                .amount(bankOperation.getAmount())
                .destinationIban(bankOperation.getDestinationIban())
                .creationDate(bankOperation.getCreationDate())
                .lastUpdate(bankOperation.getLastUpdate())
                .type(bankOperation.getType())
                .build();
    }

    public static BankOperation toEntity(BankOperationDto bankOperationDto){
        if(bankOperationDto == null){
            return null;
            //todo thrown an exception
        }
        return BankOperation
                .builder()
                .amount(bankOperationDto.getAmount())
                .creationDate(bankOperationDto.getCreationDate())
                .lastUpdate(bankOperationDto.getLastUpdate())
                .destinationIban(bankOperationDto.getDestinationIban())
                .type(bankOperationDto.getType())
                .build();
    }
}

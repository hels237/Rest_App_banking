package com.helscorp.banking.exceptions;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class InvalidOperationException extends RuntimeException{

    private final String errorMsg;
    private final String operationId;
    private final String source;
}

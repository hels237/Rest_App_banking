package com.helscorp.banking.handlers;


import com.helscorp.banking.exceptions.InvalidOperationException;
import com.helscorp.banking.exceptions.ObjectValidationException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ObjectValidationException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(ObjectValidationException exception){

        ErrorResponse errorResponse = ErrorResponse.builder()
                                                .errorMessage("invalid object")
                                                .errorSource(exception.getViolationSources())
                                                .errorValidation(exception.getViolations())
                                                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);

    }


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(EntityNotFoundException exception){

        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorMessage(exception.getMessage())
                .errorSource(exception.getClass().getName())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }


    @ExceptionHandler(InvalidOperationException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(InvalidOperationException exception){

        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorMessage(exception.getErrorMsg())
                .errorSource(exception.getSource())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(errorResponse);
    }

/*    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(){

        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorMessage("a user already exist with provided Email")
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);

    }*/

}


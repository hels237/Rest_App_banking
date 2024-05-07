package com.helscorp.banking;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;



@Component
public class ObjectsValidator <T> {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    private final Validator validator = factory.getValidator();


    public  void validate(T objectToValidate){

        //get the violations to the set list
        Set<ConstraintViolation<T>> violations = validator.validate(objectToValidate);

        //verify if there is violations
        //if yes get the the message only
        if(!violations.isEmpty()){
            Set<String> errorMessages = violations.stream()
                                                    .map(ConstraintViolation::getMessage)
                                                    .collect(Collectors.toSet());

            //todo throw an exception
            throw new ObjectValidationException(errorMessages,objectToValidate.getClass().getName());
        }
    }
}

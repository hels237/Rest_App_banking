package com.helscorp.banking;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
@Getter
public class ObjectValidationException extends RuntimeException {

    private final Set<String> violations;

    private final String violationSources;


}

package com.javeriana.ecotech.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * EntityValidationException
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EntityValidationException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public EntityValidationException() {
        super();
    }

    public EntityValidationException(String msg) {
        super(msg);
    }
}
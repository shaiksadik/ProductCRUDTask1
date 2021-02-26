
package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 8817354433519808751L;

    public ProductNotFoundException(String message) {

        super(message);
    }

}

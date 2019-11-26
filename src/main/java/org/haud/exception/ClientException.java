package org.haud.exception;

import org.haud.utils.Errors;
import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class ClientException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private HttpStatus httpCode;
    private Errors errors;
    
    
    public ClientException(HttpStatus httpCode, Errors errors) {
        this.httpCode = httpCode;
        this.errors = errors;
    }
    

}

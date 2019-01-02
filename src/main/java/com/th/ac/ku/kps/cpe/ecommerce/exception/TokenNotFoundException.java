package com.th.ac.ku.kps.cpe.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class TokenNotFoundException extends RuntimeException {
    public TokenNotFoundException(String excepition) {
        super(excepition);
    }
}

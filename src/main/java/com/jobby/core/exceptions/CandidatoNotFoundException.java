package com.jobby.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseBody
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CandidatoNotFoundException extends RuntimeException{
    public CandidatoNotFoundException(String message) {
        super(message);
    }
}

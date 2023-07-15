package com.jobby.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseBody
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EnderecoInvalidoException extends RuntimeException{
    public EnderecoInvalidoException(String message) {
        super(message);
    }
}

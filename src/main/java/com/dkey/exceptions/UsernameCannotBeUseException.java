package com.dkey.exceptions;

import com.dkey.constant.ExceptionConstant;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UsernameCannotBeUseException extends RuntimeException {
    public UsernameCannotBeUseException(){
        super(ExceptionConstant.USERNAME_REJECTED);
    }
}

package com.dkey.exceptions;

import com.dkey.constant.ExceptionConstant;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AdminNotFoundException extends RuntimeException {
    public AdminNotFoundException(){
        super(ExceptionConstant.ADMIN_NOT_FOUND);
    }
}

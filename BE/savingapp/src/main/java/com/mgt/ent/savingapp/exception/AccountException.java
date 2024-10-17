package com.mgt.ent.savingapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class AccountException extends  RuntimeException{
    public AccountException(String message){
        super(message);
    }
}

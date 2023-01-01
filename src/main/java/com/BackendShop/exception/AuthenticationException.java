package com.BackendShop.exception;

import javax.print.attribute.standard.Severity;

import com.BackendShop.message.Message;

public class AuthenticationException extends BaseException {

    public AuthenticationException(Message message , Throwable rootcase) {
        super(message, Severity.WARNING, rootcase);
    }
    
}

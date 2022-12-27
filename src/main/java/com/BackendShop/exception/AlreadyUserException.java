package com.BackendShop.exception;

import javax.print.attribute.standard.Severity;

import com.BackendShop.message.Message;

public class AlreadyUserException  extends BaseException{

    public AlreadyUserException(Message message, Throwable rootcase) {
        super(message, Severity.WARNING, rootcase);
    }
    
}

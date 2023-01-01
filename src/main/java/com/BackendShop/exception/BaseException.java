package com.BackendShop.exception;

import javax.print.attribute.standard.Severity;

import com.BackendShop.message.Message;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class BaseException extends RuntimeException {

    private Message msg;
    private Severity severity;

    @JsonIgnore
    private Throwable rootcase;

    public BaseException(Message message, Severity severity, Throwable rootcase) {
        super(message.getContent(), rootcase);
        this.msg = message;
        this.severity = severity;
        this.rootcase = rootcase;
    }

    public BaseException(String string, String code, Object[] args, Object object) {
    }

    public Message getMsg() {
        return msg;
    }

    public void setMsg(Message msg) {
        this.msg = msg;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

}

package com.BackendShop.exception;

import java.time.LocalDateTime;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {
	
	
    @ExceptionHandler(NotFoundException.class)
    public ApiError handlerNotFoundException(NotFoundException ex, WebRequest req) {
        return new ApiError(LocalDateTime.now(), ex.getMessage());
    }

    @ExceptionHandler({AuthenticationException.class, AlreadyUserException.class})
    public ApiError handlerDuplicateRecordException(AlreadyUserException ex, WebRequest req) {

        return  new ApiError(LocalDateTime.now(), ex.getMessage());
        
    }

    // Xử lý tất cả các exception chưa được khai báo
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError handlerException(Exception ex, WebRequest req) {
        // Log err
        return  new ApiError(LocalDateTime.now(), ex.getMessage());
            }
}
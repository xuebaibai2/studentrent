package com.caydenli.web.controller;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by Cayden on 16/6/20.
 */
@ControllerAdvice
public class DatabaseErorHandler {
    @ExceptionHandler(DataAccessException.class)
    public String handleDatabaseException(DataAccessException ex){
        return "error";
    }
}

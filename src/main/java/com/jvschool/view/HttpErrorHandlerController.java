package com.jvschool.view;

import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Log4j
@ControllerAdvice
public class HttpErrorHandlerController {

    @ExceptionHandler(Exception.class)
    public String handler(Exception ex) {
        log.error(ex.toString());
        return "error/error";
    }
}

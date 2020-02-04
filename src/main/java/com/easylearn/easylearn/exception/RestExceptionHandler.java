/**
 * @Author: Mahmoud Abdelrahman, Steve Titinang
 * RestExceptionHandler Exception class is where all RestException
 * specifications are declared.
 *
 */
package com.easylearn.easylearn.exception;

import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice // All controllers is being advised by this controller
public final class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Object> handleBadRequest(ResponseStatusException ex) {
        ApiError apiError = ApiError.builder().status(HttpStatus.BAD_REQUEST)
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}

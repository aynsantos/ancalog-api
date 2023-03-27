package com.ancalaghon.ancalog.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<Error.Fields> fieldsList = new ArrayList<>();

        for (ObjectError err  : ex.getBindingResult().getAllErrors()) {
            String name = ((FieldError) err).getField();
            String message = err.getDefaultMessage();

            fieldsList.add(new Error.Fields(name, message));
        }



        Error error = new Error();
        error.setStatus(status.value());
        error.setTimeStamp(OffsetDateTime.now());
        error.setTitle("One or more fields are invalid. Check and try again.");
        error.setField(fieldsList);


        return handleExceptionInternal(ex,error, headers, status, request);

    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleBusiness (BusinessException ex, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        Error error = new Error();
        error.setStatus(status.value());
        error.setTimeStamp(OffsetDateTime.now());
        error.setTitle(ex.getMessage());



        return handleExceptionInternal(ex, error, new HttpHeaders(), status, request);

    }
}

package com.gwabs.spring_example.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

public interface CustomizedResponseEntityExceptionHandle {
    ResponseEntity<ErrorDetails> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                              HttpStatusCode statusCode);
}

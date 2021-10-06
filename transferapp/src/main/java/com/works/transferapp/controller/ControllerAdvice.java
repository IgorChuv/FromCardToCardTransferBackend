package com.works.transferapp.controller;


import com.works.transferapp.exceptions.ErrorInputData;
import com.works.transferapp.exceptions.ErrorTransfer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(ErrorInputData.class)
    public ResponseEntity<?> handleIO(ErrorInputData ex) {
        return new ResponseEntity<>(new ErrorInputData(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ErrorTransfer.class)
    public ResponseEntity<?> handleET(ErrorTransfer ex) {
        return new ResponseEntity<>(new ErrorTransfer(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
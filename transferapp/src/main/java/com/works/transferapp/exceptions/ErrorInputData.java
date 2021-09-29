package com.works.transferapp.exceptions;

public class ErrorInputData extends RuntimeException {
    public ErrorInputData(String msg) {
        super(msg);
    }
}
package com.works.transferapp.service;

import org.springframework.stereotype.Component;

@Component
public class OperationRegistrar {
    private volatile int operationsCount = 0;
    private volatile String verificationCode = "0000";

    protected synchronized int getId() {
        operationsCount++;
        return operationsCount;
    }

    protected synchronized String getVerificationCode() {
        //Generate code
        return verificationCode;
    }
}

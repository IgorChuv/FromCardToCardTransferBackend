package com.works.transferapp.service;

public class OperationRegistrar {
    private int operationsCount = 0;
    private String verificationCode = "0000";

    public int getId() {
        operationsCount++;
        return operationsCount;
    }

    public String getVerificationCode() {
        //Generate code
        return verificationCode;
    }
}

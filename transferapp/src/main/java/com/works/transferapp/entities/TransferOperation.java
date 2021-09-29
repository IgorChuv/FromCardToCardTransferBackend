package com.works.transferapp.entities;

public class TransferOperation {

    private final String operationId;
    private final String code;

    public TransferOperation(int operationId, String code) {
        this.operationId = Integer.toString(operationId);
        this.code = code;
    }

    public String getOperationId() {
        return operationId;
    }

    public String getCode() {
        return code;
    }



    @Override
    public String toString() {
        return "Идентификатор операции: " + operationId + " Код подтверждения: " + code;
    }

}

package com.works.transferapp.service;

import com.works.transferapp.entities.TransferOperation;
import com.works.transferapp.entities.TransferRequest;
import com.works.transferapp.exceptions.ErrorInputData;
import com.works.transferapp.exceptions.ErrorTransfer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class TransferHandler extends Logger {

    private final OperationRegistrar registrar;
    private final CardValidator validator;

    public TransferHandler(OperationRegistrar registrar, CardValidator validator) {
        this.registrar = registrar;
        this.validator = validator;
    }

    public ResponseEntity<TransferOperation> confirmCode(TransferOperation tOp) {
        log("- Ответ клиента: " + tOp);
        if (tOp.getCode().equals(registrar.getVerificationCode())) {
            log("- Код подтверждения принят. Операция прошла успешно");
            return ResponseEntity.status(HttpStatus.OK).body(tOp);
        }
        log("- Код подтверждения не принят. Операция отменена");
        throw new ErrorInputData("Неверный код подтверждения");
    }

    public ResponseEntity<TransferOperation> confirmTransfer(TransferRequest tRe) throws ErrorTransfer {
        TransferOperation transferOperation = new TransferOperation(registrar.getId(), registrar.getVerificationCode());
        log("- Operation Id: " + transferOperation.getOperationId() + " / Данные операции:" + tRe);

        if (!validator.sendersCardValidation(tRe)) {
            log("- Operation Id: " + transferOperation.getOperationId() + " / Неверные данные карты отправителя. Операция отменена");
            throw new ErrorInputData("Неверные данные карты отправителя.");
        }

        if (!validator.recipientsCardValidation(tRe)) {
            log("- Operation Id: " + transferOperation.getOperationId() + " / Неверные данные карты получателя. Операция отменена");
            throw new ErrorInputData("Неверные данные карты получателя");
        }

        log("- Operation Id: " + transferOperation.getOperationId() + " / Данные приняты / Ответ клиенту: " + HttpStatus.OK + " " + transferOperation);
        return ResponseEntity.status(HttpStatus.OK).body(transferOperation);
    }

}


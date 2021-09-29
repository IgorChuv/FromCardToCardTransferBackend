package com.works.transferapp.controller;

import com.works.transferapp.exceptions.ErrorInputData;
import com.works.transferapp.entities.TransferRequest;
import com.works.transferapp.entities.TransferOperation;
import com.works.transferapp.service.CardValidator;
import com.works.transferapp.service.Logger;
import com.works.transferapp.service.OperationRegistrar;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
public class Controller extends Logger {

    OperationRegistrar registrar = new OperationRegistrar();
    TransferOperation transferOperation;

    public Controller() {
    }

    @PostMapping("/confirmOperation")
    public ResponseEntity<TransferOperation> confirmOperation(@RequestBody TransferOperation transOp) {
        log("- Ответ клиента: " + transOp);
        if (transOp.getCode().equals(registrar.getVerificationCode())) {
            log("- Код подтверждения принят. Операция прошла успешно");
            return ResponseEntity.status(HttpStatus.OK).body(transOp);
        }
        log("- Код подтверждения не принят. Операция отменена");
        throw new ErrorInputData("Неверный код подтверждения");
    }

    @ResponseBody
    @PostMapping(value = "/transfer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> transfer(@RequestBody TransferRequest transferRequest) throws ErrorInputData, IOException {

        transferOperation = new TransferOperation(registrar.getId(), registrar.getVerificationCode());
        log("- Operation Id: " + transferOperation.getOperationId() + " / Данные операции:" + transferRequest);

        if (!CardValidator.sendersCardValidation(transferRequest)) {
            log("- Operation Id: " + transferOperation.getOperationId() + " / Неверные данные карты отправителя. Операция отменена");
            throw new ErrorInputData("Неверные данные карты отправителя.");
        }

        if (!CardValidator.recipientsCardValidation(transferRequest)) {
            log("- Operation Id: " + transferOperation.getOperationId() + " / Неверные данные карты получателя. Операция отменена");
            throw new ErrorInputData("Неверные данные карты получателя");
        }

        log("- Operation Id: " + transferOperation.getOperationId() + " / Данные приняты / Ответ клиенту: " + HttpStatus.OK + " " + transferOperation);
        return ResponseEntity.status(HttpStatus.OK).body(transferOperation);
    }
}


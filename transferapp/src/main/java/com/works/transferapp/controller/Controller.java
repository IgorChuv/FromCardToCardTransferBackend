package com.works.transferapp.controller;

import com.works.transferapp.exceptions.ErrorInputData;
import com.works.transferapp.entities.TransferRequest;
import com.works.transferapp.entities.TransferOperation;
import com.works.transferapp.service.Logger;
import com.works.transferapp.service.TransferHandler;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
public class Controller extends Logger {

    private final TransferHandler handler;

    public Controller(TransferHandler handler) {
        this.handler = handler;
    }

    @PostMapping("/confirmOperation")
    public ResponseEntity<TransferOperation> confirmOperation(@RequestBody TransferOperation tOp) {
        return handler.confirmCode(tOp);
    }

    @ResponseBody
    @PostMapping(value = "/transfer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> transfer(@RequestBody TransferRequest transferRequest) throws ErrorInputData, IOException {
        return handler.confirmTransfer(transferRequest);

    }

}
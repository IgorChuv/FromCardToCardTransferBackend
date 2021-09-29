package com.works.transferapp.exceptions;

import java.io.IOException;

public class ErrorTransfer extends IOException {
    public ErrorTransfer(String msg) {
        super(msg);
    }
}
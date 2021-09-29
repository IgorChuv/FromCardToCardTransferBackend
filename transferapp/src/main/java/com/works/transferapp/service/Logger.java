package com.works.transferapp.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static final String logFilePath = "src/main/resources/log.txt";
    private static final String dateTimePattern = "dd/MM/yyyy HH:mm:ss ";

    public static void log(String message) {
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(logFilePath, true))) {
            wr.write(LocalDateTime.now().format(DateTimeFormatter.ofPattern(dateTimePattern)) + message + "\r\n");
            wr.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

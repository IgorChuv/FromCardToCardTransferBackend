package com.works.transferapp.service;

import com.works.transferapp.exceptions.ErrorTransfer;
import com.works.transferapp.entities.TransferRequest;
import java.io.*;

public class CardValidator {

    private static final String dataBasePath = "src/main/resources/cards.txt";

    public static boolean recipientsCardValidation(TransferRequest transferRequest) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(dataBasePath))) {
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                String[] cardData = s.split(" ");
                if (transferRequest.getCardToNumber().equals(cardData[0])) {
                    return true;
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public static boolean sendersCardValidation(TransferRequest transferRequest) throws ErrorTransfer {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(dataBasePath))) {
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                String[] cardData = s.split(" ");
                if (transferRequest.getCardFromNumber().equals(cardData[0])
                        && transferRequest.getCardFromValidTill().equals(cardData[1])
                        && transferRequest.getCardFromCVV().equals(cardData[2])) {
                    return true;
                }
            }
        } catch (IOException ex) {
            throw new ErrorTransfer("Ошибка сервера. Попробуйте повторить операцию позже");
        }
        return false;
    }
}

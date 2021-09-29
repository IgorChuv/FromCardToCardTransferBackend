package com.works.transferapp.entities;

public class TransferRequest {

    private final String cardFromNumber;
    private final String cardFromValidTill;
    private final String cardFromCVV;
    private final String cardToNumber;
    private final Amount amount;

    public TransferRequest(String cardFromNumber, String cardFromValidTill, String cardFromCVV, String cardToNumber, Amount amount) {
        this.cardFromNumber = cardFromNumber;
        this.cardFromValidTill = cardFromValidTill;
        this.cardFromCVV = cardFromCVV;
        this.cardToNumber = cardToNumber;
        this.amount = amount;
    }

    public String getCardFromNumber() {
        return cardFromNumber;
    }

    public String getCardFromValidTill() {
        return cardFromValidTill;
    }

    public String getCardFromCVV() {
        return cardFromCVV;
    }

    public String getCardToNumber() {
        return cardToNumber;
    }

    public Amount getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return " Номер карты отправителя: " + cardFromNumber + ", " +
                "Карта действительна до: " + cardFromValidTill + ", " +
                "CVV: " + cardFromCVV + ", " +
                "Номер карты получателя: " + cardToNumber + ", " +
                "Сумма перевода: " + amount;
    }
}

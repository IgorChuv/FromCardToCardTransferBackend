package com.works.transferapp.entities;

public class ClientCard {

    private final String cardFromNumber;
    private final String cardFromValidTill;
    private final String cardFromCVV;

    public ClientCard(String cardFromNumber, String cardFromValidTill, String cardFromCVV) {
        this.cardFromNumber = cardFromNumber;
        this.cardFromValidTill = cardFromValidTill;
        this.cardFromCVV = cardFromCVV;
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

    @Override
    public String toString() {
        return "Номер карты: " + cardFromNumber + ", Действует до: " + cardFromValidTill + ", CVV: " + cardFromCVV;
    }
}

package com.works.transferapp.entities;

public class Amount {

    private final String currency;
    private final Integer value;

    public Amount(String currency, Integer value) {
        this.currency = currency;
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value + " " + currency;
    }

}

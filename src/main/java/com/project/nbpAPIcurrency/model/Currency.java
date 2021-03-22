package com.project.nbpAPIcurrency.model;

import org.springframework.stereotype.Component;

@Component
public class Currency {
    private String name;
    private String currencyCode;
    private String value;

    public Currency(String name, String currencyCode, String value) {
        this.name = name;
        this.currencyCode = currencyCode;
        this.value = value;
    }

    public Currency() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}


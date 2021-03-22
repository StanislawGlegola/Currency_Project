package com.project.nbpAPIcurrency.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CurrencyList extends Currency{
    private List<Currency> currencyList;
    private String number;

    public CurrencyList(List<Currency> currencyList, String number) {
        this.currencyList = currencyList;
        this.number = number;
    }

    public CurrencyList(List<Currency> currencyList) {
        this.currencyList = currencyList;
    }

    public CurrencyList() {
    }

    public List<Currency> getCurrencyList() {
        return currencyList;
    }

    public void setCurrencyList(List<Currency> currencyList) {
        this.currencyList = currencyList;
    }

    public void addCurrency(Currency currency) {
        this.currencyList.add(currency);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

package com.project.nbpAPIcurrency.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CurrencyList {
    private List<Currency> currencyList;

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
}

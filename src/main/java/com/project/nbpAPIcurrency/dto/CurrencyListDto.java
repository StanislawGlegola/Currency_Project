package com.project.nbpAPIcurrency.dto;

import com.project.nbpAPIcurrency.model.Currency;
import com.project.nbpAPIcurrency.model.CurrencyList;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CurrencyListDto {

    private final CurrencyList currencyList;

    public CurrencyListDto(CurrencyList currencyList) {
        this.currencyList = currencyList;
    }

    public List currListDto(){
        List<Currency> cur = new ArrayList<>();
        Currency cur1 = new Currency("Zloty", 1.0);
        Currency cur2 = new Currency("Euro", 2.0);
        Currency cur3 = new Currency("Funt", 4.0);
        Currency cur4 = new Currency("Yen", 3.0);
        cur.add(cur1);
        cur.add(cur2);
        cur.add(cur3);
        cur.add(cur4);
        currencyList.setCurrencyList(cur);
        return currencyList.getCurrencyList();
    }
}

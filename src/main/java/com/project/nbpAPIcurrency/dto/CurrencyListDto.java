package com.project.nbpAPIcurrency.dto;

import com.project.nbpAPIcurrency.model.Currency;
import com.project.nbpAPIcurrency.model.CurrencyList;
import com.project.nbpAPIcurrency.parser.Reader;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CurrencyListDto {

    private final CurrencyList currencyList;
    private final Reader reader;

    public CurrencyListDto(CurrencyList currencyList, Reader reader) {
        this.currencyList = currencyList;
        this.reader = reader;
    }

    public CurrencyList currListDto() {
        Currency cur1 = new Currency("Zloty", "Elo", "1.0");
        Currency cur2 = new Currency("Euro", "Elo", "2.0");
        Currency cur3 = new Currency("Funt", "Elo", "4.0");
        Currency cur4 = new Currency("Yen", "Elo", "3.0");
        List<Currency> cur = Arrays.asList(cur1,cur2,cur3,cur4);
        currencyList.setNumber("123");
        currencyList.setCurrencyList(cur);
        return currencyList;
    }

    public List createListFromReader(){
        reader.readFromUrl();
        return currencyList.getCurrencyList();
    }

}

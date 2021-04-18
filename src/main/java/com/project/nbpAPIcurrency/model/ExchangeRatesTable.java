package com.project.nbpAPIcurrency.model;

import com.project.nbpAPIcurrency.dto.RatesDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExchangeRatesTable {

    private String no;
    private List rates;
    private String table;
    private String effectiveDate;

    public ExchangeRatesTable() {
    }

    public ExchangeRatesTable(String no, List rates, String table, String effectiveDate) {
        this.no = no;
        this.rates = rates;
        this.table = table;
        this.effectiveDate = effectiveDate;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public List getRates() {
        return rates;
    }

    public void setRates(List rates) {
        this.rates = rates;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}

package com.project.nbpAPIcurrency.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExchangeRatesTableDTO {

    @JsonProperty("no")
    private String no;
    @JsonProperty("rates")
    private List rates;
    @JsonProperty("table")
    private String table;
    @JsonProperty("effectiveDate")
    private String effectiveDate;

    public ExchangeRatesTableDTO(String no, List rates, String table, String effectiveDate) {
        this.no = no;
        this.rates = rates;
        this.table = table;
        this.effectiveDate = effectiveDate;
    }

    public ExchangeRatesTableDTO() {
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

    public void setRates(List rateDTO) {
        this.rates = rateDTO;
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

    @Override
    public String toString() {
        return "ClassPojo [no = " + no + ", ratesDTO = " + rates + ", table = " + table + ", effectiveDate = " + effectiveDate + "]";
    }
}




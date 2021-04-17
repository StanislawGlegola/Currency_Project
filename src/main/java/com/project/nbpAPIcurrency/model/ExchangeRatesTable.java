package com.project.nbpAPIcurrency.model;

import com.project.nbpAPIcurrency.dto.RatesDTO;

import java.util.List;

public class ExchangeRatesTable {

    private String no;
    private List rateDTO;
    private String table;
    private String effectiveDate;

    public ExchangeRatesTable() {
    }

    public ExchangeRatesTable(String no, List rateDTO, String table, String effectiveDate) {
        this.no = no;
        this.rateDTO = rateDTO;
        this.table = table;
        this.effectiveDate = effectiveDate;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public List getRateDTO() {
        return rateDTO;
    }

    public void setRateDTO(List rateDTO) {
        this.rateDTO = rateDTO;
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

package com.project.nbpAPIcurrency.dto;

public class ExchangeRatesTableDTO {

    private String no;
    private RatesDTO[] rateDTO;
    private String table;
    private String effectiveDate;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public RatesDTO[] getRates() {
        return rateDTO;
    }

    public void setRates(RatesDTO[] rateDTO) {
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

    @Override
    public String toString() {
        return "ClassPojo [no = " + no + ", ratesDTO = " + rateDTO + ", table = " + table + ", effectiveDate = " + effectiveDate + "]";
    }
}




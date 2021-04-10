package com.project.nbpAPIcurrency.dto;

public class RatesDTO {

    private String code;
    private String mid;
    private String currency;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "ClassPojo [code = " + code + ", mid = " + mid + ", currency = " + currency + "]";
    }
}
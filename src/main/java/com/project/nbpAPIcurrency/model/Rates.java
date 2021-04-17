package com.project.nbpAPIcurrency.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rates {

    private String currency;
    private String code;
    private String mid;

    public Rates(String currency, String code, String mid) {
        this.currency = currency;
        this.code = code;
        this.mid = mid;
    }

    public Rates() {
    }

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
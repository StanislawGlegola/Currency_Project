package com.project.nbpAPIcurrency.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class RatesDTO {

    @JsonProperty("currency")
    private String currency;
    @JsonProperty("code")
    private String code;
    @JsonProperty("mid")
    private String mid;

    public RatesDTO(String currency, String code, String mid) {
        this.currency = currency;
        this.code = code;
        this.mid = mid;
    }

    public RatesDTO() {
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
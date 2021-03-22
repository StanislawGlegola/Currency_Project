package com.project.nbpAPIcurrency.dto;

import com.project.nbpAPIcurrency.model.Currency;
import org.springframework.stereotype.Component;

@Component
public class CurrencyDto {

    private final Currency currency;

    public CurrencyDto(Currency currency) {
        this.currency = currency;
    }
}

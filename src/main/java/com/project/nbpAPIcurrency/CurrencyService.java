package com.project.nbpAPIcurrency;
import com.project.nbpAPIcurrency.dto.CurrencyListDto;
import com.project.nbpAPIcurrency.model.Currency;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyService {

    private final CurrencyListDto currencyListDto;

    public CurrencyService(CurrencyListDto currencyListDto) {
        this.currencyListDto = currencyListDto;
    }

    public List getListe(){
        return currencyListDto.currListDto();
    }
}

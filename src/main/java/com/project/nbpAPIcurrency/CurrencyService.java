package com.project.nbpAPIcurrency;
import com.project.nbpAPIcurrency.dto.CurrencyDto;
import com.project.nbpAPIcurrency.dto.CurrencyListDto;
import com.project.nbpAPIcurrency.model.CurrencyList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {

    @Autowired
    CurrencyListDto currencyListDto;
    CurrencyDto currencyDto;

    public CurrencyList getCurrencyList(){
        return currencyListDto.currListDto();
    }

    public List getXMLList(){
        return currencyListDto.createListFromReader();
    }
}

package com.project.nbpAPIcurrency;

import com.project.nbpAPIcurrency.dto.ExchangeRatesTableDTO;
import com.project.nbpAPIcurrency.dto.RatesDTO;
import com.project.nbpAPIcurrency.parser.Mapper;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CurrencyService {

    Mapper mapper;

    public ExchangeRatesTableDTO return_ERT_DTO_Object() throws IOException {

        return mapper.mapperThenDto();
    }
}

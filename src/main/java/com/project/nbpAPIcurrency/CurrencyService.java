package com.project.nbpAPIcurrency;

import com.project.nbpAPIcurrency.dto.ExchangeRatesTableDTO;
import com.project.nbpAPIcurrency.model.ExchangeRatesTable;
import com.project.nbpAPIcurrency.parser.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CurrencyService {

    @Autowired
    Mapper mapper;

    public ExchangeRatesTableDTO return_ERT_DTO_Object() throws IOException {

        return mapper.mapperThenDto();
    }

    public ExchangeRatesTable return_Object() throws IOException {

        return mapper.dtoToEntity();
    }

}

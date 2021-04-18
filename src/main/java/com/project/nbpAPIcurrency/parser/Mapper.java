package com.project.nbpAPIcurrency.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.nbpAPIcurrency.dto.ExchangeRatesTableDTO;
import com.project.nbpAPIcurrency.model.ExchangeRatesTable;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Mapper {

    public static ExchangeRatesTableDTO mapperThenDto() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = JsonReader.getDataFromUrl("http://api.nbp.pl/api/exchangerates/tables/a?format=json");
        ExchangeRatesTableDTO exchangeRatesTableDTO = objectMapper.readValue(json, ExchangeRatesTableDTO.class);
        return exchangeRatesTableDTO;
    }

    public static ExchangeRatesTable dtoToEntity() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ExchangeRatesTable exchangeRatesTable = objectMapper.convertValue(mapperThenDto(),ExchangeRatesTable.class);
        return exchangeRatesTable;
    }

}

package com.project.nbpAPIcurrency.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.nbpAPIcurrency.dto.ExchangeRatesTableDTO;

import java.io.IOException;

public class Mapper {

    public static ExchangeRatesTableDTO mapperThenDto() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = JsonReader.getDataFromUrl("http://api.nbp.pl/api/exchangerates/tables/a?format=json");
        ExchangeRatesTableDTO exchangeRatesTableDTO = objectMapper.readValue(json, ExchangeRatesTableDTO.class);
        //String table = exchangeRatesTableDTO.getTable();
        return exchangeRatesTableDTO;
    }


}

package com.project.nbpAPIcurrency.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.nbpAPIcurrency.dto.daily.DailyExchangeRatesTableDTO;
import com.project.nbpAPIcurrency.dto.code.CodeExchangeRatesTableDTO;
import com.project.nbpAPIcurrency.model.ExchangeRatesTable;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    @SneakyThrows
    public static DailyExchangeRatesTableDTO mapperDailyToDto(String dailyCurrency) {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = JsonReader.getDataFromUrl(dailyCurrency);
        DailyExchangeRatesTableDTO dailyExchangeRatesTableDTO = objectMapper.readValue(json, DailyExchangeRatesTableDTO.class);
        return dailyExchangeRatesTableDTO;
    }

    @SneakyThrows
    public static ExchangeRatesTable dtoToEntity(String dailyCurrency) {
        ObjectMapper objectMapper = new ObjectMapper();
        ExchangeRatesTable exchangeRatesTable = objectMapper.convertValue(mapperDailyToDto(dailyCurrency),ExchangeRatesTable.class);
        return exchangeRatesTable;
    }

    @SneakyThrows
    public static CodeExchangeRatesTableDTO mapperCodeToDto(String dailyCurrency) {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = JsonReader.getDataFromUrl(dailyCurrency);
        CodeExchangeRatesTableDTO codeExchangeRatesTableDTO = objectMapper.readValue(json, CodeExchangeRatesTableDTO.class);
        return codeExchangeRatesTableDTO;
    }

    public CodeExchangeRatesTableDTO generateLinkToGetCode(String selectCode) {
        String finishedBuild = "http://api.nbp.pl/api/exchangerates/rates/a/"+selectCode+"/last/10/?format=json";

        return mapperCodeToDto(finishedBuild);
    }
}

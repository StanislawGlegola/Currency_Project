package com.project.nbpAPIcurrency.util;

import org.junit.jupiter.api.Test;
import com.project.nbpAPIcurrency.dto.daily.DailyExchangeRatesTableDTO;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapperTest {

    @Test
    void shouldReturnTableALetter() throws IOException {
        DailyExchangeRatesTableDTO dailyExchangeRatesTableDTO = Mapper.mapperDailyToDto("http://api.nbp.pl/api/exchangerates/tables/a?format=json");
        String table = dailyExchangeRatesTableDTO.getTableLetter();
        assertEquals(table, "A");
        //System.out.println(table);
    }
}
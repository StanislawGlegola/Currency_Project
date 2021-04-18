package com.project.nbpAPIcurrency.parser;

import org.junit.jupiter.api.Test;
import com.project.nbpAPIcurrency.dto.ExchangeRatesTableDTO;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static com.project.nbpAPIcurrency.parser.Mapper.mapperThenDto;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MapperTest {

    @Test
    void shouldReturnTableALetter() throws IOException {
        ExchangeRatesTableDTO exchangeRatesTableDTO = mapperThenDto();
        String table = exchangeRatesTableDTO.getTable();
        assertEquals(table, "A");
        //System.out.println(table);

    }
}
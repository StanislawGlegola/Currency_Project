package com.project.nbpAPIcurrency.parser;

import org.junit.jupiter.api.Test;
import com.project.nbpAPIcurrency.dto.ExchangeRatesTableDTO;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static com.project.nbpAPIcurrency.parser.Mapper.mapperToDto;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MapperTest {

    @Test
    void shouldReturnTableALetter() throws IOException {
        ExchangeRatesTableDTO exchangeRatesTableDTO = mapperToDto();
        String table = exchangeRatesTableDTO.getTableLetter();
        assertEquals(table, "A");
        //System.out.println(table);

    }
}
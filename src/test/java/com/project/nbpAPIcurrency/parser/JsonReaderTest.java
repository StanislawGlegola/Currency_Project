package com.project.nbpAPIcurrency.parser;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.project.nbpAPIcurrency.parser.JsonReader.getDataFromUrl;
import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest {

    @Test
    void shouldReturnFalseIfJSONisEmpty() throws IOException {
        //given
        final String url = "http://api.nbp.pl/api/exchangerates/tables/a?format=json";
        //when
        String data = getDataFromUrl(url);
        //then
        System.out.println(data);
        assertFalse(data.isEmpty());
    }

    @Test
    void shouldReturnTrueIFFirstAndLastCharacterIsACurlyBrackets() throws IOException {
        //given
        final String url = "http://api.nbp.pl/api/exchangerates/tables/a?format=json";
        //when
        String data = getDataFromUrl(url);
        //then
        assertTrue(data.charAt(0)=='{');
        assertTrue(data.charAt(data.length() - 1)=='}');
    }
}
package com.project.nbpAPIcurrency.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class ExchangeRatesTableDTO {

    @JsonProperty("no")
    private String number;
    @JsonProperty("rates")
    private List rates;
    @JsonProperty("table")
    private String tableLetter;
    @JsonProperty("effectiveDate")
    private String effectiveDate;

}




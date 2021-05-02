package com.project.nbpAPIcurrency.dto.code;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class CodeRatesDTO {

    @JsonProperty("effectiveDate")
    private String effectiveDate;
    @JsonProperty("mid")
    private String mid;
    @JsonProperty("no")
    private String no;

}
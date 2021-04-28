package com.project.nbpAPIcurrency.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "ExchangeRatesTable")
public class ExchangeRatesTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("table")
    private String tableLetter;
    private String no;
    private String effectiveDate;
    @OneToMany(targetEntity = Rates.class,cascade = CascadeType.ALL)
    private List<Rates> rates;

}
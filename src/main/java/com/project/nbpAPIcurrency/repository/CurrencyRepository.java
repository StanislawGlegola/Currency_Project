package com.project.nbpAPIcurrency.repository;

import com.project.nbpAPIcurrency.model.ExchangeRatesTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyRepository extends JpaRepository<ExchangeRatesTable, Long> {
    ExchangeRatesTable findExchangeRatesTableById(Long id);
    List findAllByRates(String rateName);
}

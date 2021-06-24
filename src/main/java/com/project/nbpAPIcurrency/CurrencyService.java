package com.project.nbpAPIcurrency;

import com.project.nbpAPIcurrency.dto.code.CodeRatesDTO;
import com.project.nbpAPIcurrency.dto.daily.DailyExchangeRatesTableDTO;
import com.project.nbpAPIcurrency.dto.code.CodeExchangeRatesTableDTO;
import com.project.nbpAPIcurrency.model.ExchangeRatesTable;
import com.project.nbpAPIcurrency.util.Mapper;
import com.project.nbpAPIcurrency.repository.CurrencyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.project.nbpAPIcurrency.util.Mapper.mapperCodeToDto;

@Service
public class CurrencyService {

    private final String dailyCurrency = "http://api.nbp.pl/api/exchangerates/tables/a?format=json";
    private final String specificCurrency = "http://api.nbp.pl/api/exchangerates/rates/a/gbp/last/10/?format=json";
    private final Mapper mapper;
    private final CurrencyRepository currencyRepository;

    public CurrencyService(Mapper mapper, CurrencyRepository currencyRepository) {
        this.mapper = mapper;
        this.currencyRepository = currencyRepository;
    }

    public DailyExchangeRatesTableDTO return_ERT_DTO_Object() {
        return mapper.mapperDailyToDto(dailyCurrency);
    }

    public ExchangeRatesTable return_Object() {
        return mapper.dtoToEntity(dailyCurrency);
    }

    public List findAllCurrencyNames(String rateName) {
        return currencyRepository.findAllByRates(rateName);
    }

    public ExchangeRatesTable saveDAOAsEntity() {
        return currencyRepository.save(mapper.dtoToEntity(dailyCurrency));
    }

    public ExchangeRatesTable repository(Long id) {
        return currencyRepository.findExchangeRatesTableById(id);
    }

    public CodeExchangeRatesTableDTO returnDailyDto() {
        CodeExchangeRatesTableDTO codeExchangeRatesTableDTO = mapperCodeToDto(specificCurrency);
        return codeExchangeRatesTableDTO;
    }

    public void saveCodesToFile(){

    }
}
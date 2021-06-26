package com.project.nbpAPIcurrency;

import com.project.nbpAPIcurrency.dto.code.CodeExchangeRatesTableDTO;
import com.project.nbpAPIcurrency.model.ExchangeRatesTable;
import com.project.nbpAPIcurrency.model.Trade;
import com.project.nbpAPIcurrency.repository.TradeRepository;
import com.project.nbpAPIcurrency.util.Mapper;
import com.project.nbpAPIcurrency.repository.CurrencyRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import static com.project.nbpAPIcurrency.util.Mapper.mapperCodeToDto;

@Service
public class CurrencyService {

    private final String specificCurrency = "http://api.nbp.pl/api/exchangerates/rates/a/gbp/last/10/?format=json";
    private final Mapper mapper;
    private final CurrencyRepository currencyRepository;
    private final TradeRepository tradeRepository;

    public CurrencyService(Mapper mapper, CurrencyRepository currencyRepository, TradeRepository tradeRepository) {
        this.mapper = mapper;
        this.currencyRepository = currencyRepository;
        this.tradeRepository = tradeRepository;
    }

/*    public DailyExchangeRatesTableDTO return_ERT_DTO_Object() {
        return mapper.mapperDailyToDto(dailyCurrency);
    }

    public ExchangeRatesTable return_Object() {
        return mapper.dtoToEntity(dailyCurrency);
    }

    public List findAllCurrencyNames(String rateName) {
        return currencyRepository.findAllByRates(rateName);
    }*/

    public ExchangeRatesTable repository(Long id) {
        return currencyRepository.findExchangeRatesTableById(id);
    }

    public CodeExchangeRatesTableDTO returnCodeDto() {
        return mapperCodeToDto(specificCurrency);
    }

    public CodeExchangeRatesTableDTO generateLinkFromCode(String selectCode) {
        return mapper.generateLinkToGetCode(selectCode);
    }

    public void changeUserTrade(Trade trade) {
        tradeRepository.save(trade);
    }

    public Trade getTradesFromDB(Long id) {
        return tradeRepository.findTradesById(id);
    }
}
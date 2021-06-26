package com.project.nbpAPIcurrency.util;

import com.project.nbpAPIcurrency.model.ExchangeRatesTable;
import com.project.nbpAPIcurrency.repository.CurrencyRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class ScheduledEvents {

    private final CurrencyRepository currencyRepository;
    private final Mapper mapper;

    private final String dailyCurrency = "http://api.nbp.pl/api/exchangerates/tables/a?format=json";

    public ScheduledEvents(CurrencyRepository currencyRepository, Mapper mapper) {
        this.currencyRepository = currencyRepository;
        this.mapper = mapper;
    }

    @Configuration
    @EnableScheduling
    @ConditionalOnProperty(name = "scheduling.enabled", matchIfMissing = true)
    class SchedulingConfiguration{

    }

    @EventListener(ApplicationReadyEvent.class)
    @Scheduled(cron = "0 1 0 * * MON-FRI")
    public ExchangeRatesTable saveDAOAsEntity() {

        return currencyRepository.save(mapper.dtoToEntity(dailyCurrency));
    }
}

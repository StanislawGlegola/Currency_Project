package com.project.nbpAPIcurrency;

import com.project.nbpAPIcurrency.dto.ExchangeRatesTableDTO;
import com.project.nbpAPIcurrency.model.ExchangeRatesTable;
import com.project.nbpAPIcurrency.parser.Mapper;
import com.project.nbpAPIcurrency.repository.CurrencyRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CurrencyService {

    private final Mapper mapper;
    private final CurrencyRepository currencyRepository;

    public CurrencyService(Mapper mapper, CurrencyRepository currencyRepository) {
        this.mapper = mapper;
        this.currencyRepository = currencyRepository;
    }

    public ExchangeRatesTableDTO return_ERT_DTO_Object() throws IOException {

        return mapper.mapperToDto();
    }

    public ExchangeRatesTable return_Object() throws IOException {

        return mapper.dtoToEntity();
    }

    public ExchangeRatesTable saveDAOAsEntity() throws IOException {

        return currencyRepository.save(mapper.dtoToEntity());
    }

    public ExchangeRatesTable repository(Long id) throws IOException {
        return currencyRepository.findExchangeRatesTableById(id);
    }
}

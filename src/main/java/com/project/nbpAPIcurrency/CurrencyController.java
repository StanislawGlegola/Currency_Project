package com.project.nbpAPIcurrency;

import com.project.nbpAPIcurrency.dto.code.CodeExchangeRatesTableDTO;
import com.project.nbpAPIcurrency.model.ExchangeRatesTable;
import com.project.nbpAPIcurrency.model.Trade;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/repo")
    public ModelAndView currencyFromRepo() {
        ModelAndView modelAndView = new ModelAndView("view/currency");
        ExchangeRatesTable currencyList = currencyService.repository(1L);
        CodeExchangeRatesTableDTO codeExchangeRatesTableDTO = currencyService.returnCodeDto();
        String currency = codeExchangeRatesTableDTO.getCurrency();
        modelAndView.addObject("ratesList", currencyList.getRates());
        modelAndView.addObject("currencyName", currency);
        modelAndView.addObject("codesList", codeExchangeRatesTableDTO.getRates());
        return modelAndView;
    }

    @GetMapping("/repo/{selectCode}")
    public ModelAndView selectedCode(@PathVariable String selectCode) {
        ModelAndView modelAndView = new ModelAndView("view/currency");
        CodeExchangeRatesTableDTO codeExchangeRatesTableDTO = currencyService.generateLinkFromCode(selectCode);
        ExchangeRatesTable currencyList = currencyService.repository(1L);
        String currency = codeExchangeRatesTableDTO.getCurrency();
        modelAndView.addObject("ratesList", currencyList.getRates());
        modelAndView.addObject("currencyName", currency);
        modelAndView.addObject("codesList", codeExchangeRatesTableDTO.getRates());
        return modelAndView;
    }

    @PostMapping("/repo/update")
    public ModelAndView updateTrades(@ModelAttribute Trade trade) {
        ModelAndView modelAndView = new ModelAndView("view/currency");
        ExchangeRatesTable currencyList = currencyService.repository(1L);
        CodeExchangeRatesTableDTO codeExchangeRatesTableDTO = currencyService.returnCodeDto();
        String currency = codeExchangeRatesTableDTO.getCurrency();
        modelAndView.addObject("ratesList", currencyList.getRates());
        modelAndView.addObject("currencyName", currency);
        modelAndView.addObject("codesList", codeExchangeRatesTableDTO.getRates());
        return modelAndView;
    }
}

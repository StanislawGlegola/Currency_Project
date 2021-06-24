package com.project.nbpAPIcurrency;

import com.project.nbpAPIcurrency.dto.code.CodeExchangeRatesTableDTO;
import com.project.nbpAPIcurrency.model.ExchangeRatesTable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/repo")
    public String currencyFromRepo(Model model) {
        currencyService.saveDAOAsEntity();
        ExchangeRatesTable currencyList = currencyService.repository(1L);
        CodeExchangeRatesTableDTO codeExchangeRatesTableDTO = currencyService.returnDailyDto();
        String currency = codeExchangeRatesTableDTO.getCurrency();
        model.addAttribute("ratesList", currencyList.getRates());
        model.addAttribute("currencyName", currency);
        model.addAttribute("codesList", codeExchangeRatesTableDTO.getRates());
        return "view/currency";
    }


    @GetMapping("/dto")
    public String todaysResults(Model model) {
        ExchangeRatesTable currencyList = currencyService.return_Object();
        CodeExchangeRatesTableDTO codeExchangeRatesTableDTO = currencyService.returnDailyDto();
        String currency = codeExchangeRatesTableDTO.getCurrency();
        model.addAttribute("ratesList", currencyList.getRates());
        model.addAttribute("currencyName", currency);
        model.addAttribute("codesList", codeExchangeRatesTableDTO.getRates());

        return "view/currency";
    }
}

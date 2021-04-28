package com.project.nbpAPIcurrency;

import com.project.nbpAPIcurrency.dto.ExchangeRatesTableDTO;
import com.project.nbpAPIcurrency.model.ExchangeRatesTable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/repo")
    public String currencyFromRepo(Model model) throws IOException {
        currencyService.saveDAOAsEntity();
        ExchangeRatesTable currencyList = currencyService.repository(1L);
        model.addAttribute("ratesList", currencyList.getRates());
        //model.addAttribute("getValueJakis", getNumber);
        return "view/currency";
    }

    @GetMapping("/dto")
    public String todaysResults(Model model) throws IOException {
        ExchangeRatesTable currencyList = currencyService.return_Object();
        //String getNumber = currencyService.getCurrencyList().getNumber();
        model.addAttribute("ratesList", currencyList.getRates());
        //model.addAttribute("getValueJakis", getNumber);
        return "view/currency";
    }
}

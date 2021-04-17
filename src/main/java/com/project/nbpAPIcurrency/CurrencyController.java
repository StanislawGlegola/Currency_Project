package com.project.nbpAPIcurrency;

import com.project.nbpAPIcurrency.dto.ExchangeRatesTableDTO;
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

    @GetMapping("/")
    public String currency(Model model) throws IOException {
        ExchangeRatesTableDTO currencyList = currencyService.getCurrencyList();
        //String getNumber = currencyService.getCurrencyList().getNumber();
        model.addAttribute("ratesList", currencyList.getRates());
        //model.addAttribute("getValueJakis", getNumber);
        return "view/currency";
    }
}

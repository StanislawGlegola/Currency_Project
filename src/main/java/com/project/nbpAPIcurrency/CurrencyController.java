package com.project.nbpAPIcurrency;

import com.project.nbpAPIcurrency.model.Currency;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CurrencyController {

private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    /*@GetMapping("/login")
    public String currencyGo(Model model) {

        List<Currency> currencyList = currencyService.getCurrencyList().getCurrencyList();
        String getNumber = currencyService.getCurrencyList().getNumber();
        model.addAttribute("currencyList", currencyList);
        model.addAttribute("getValueJakis", getNumber);
        return "currency";
    }*/

    @GetMapping("/")
    public String currency(Model model) {
        List<Currency> currencyList = currencyService.getXMLList();
        String getNumber = currencyService.getCurrencyList().getNumber();
        model.addAttribute("currencyList", currencyList);
        model.addAttribute("getValueJakis", getNumber);
        return "view/currency";
    }
}

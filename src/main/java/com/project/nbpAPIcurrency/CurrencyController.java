package com.project.nbpAPIcurrency;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CurrencyController {

private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/login")
    public String currencyGo(Model model) {
        model.addAttribute("currencyList", currencyService.getListe());
        return "currency";
    }
}

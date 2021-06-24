package com.project.nbpAPIcurrency;

import com.project.nbpAPIcurrency.dto.code.CodeExchangeRatesTableDTO;
import com.project.nbpAPIcurrency.model.ExchangeRatesTable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

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
    public ModelAndView selectedCode(@PathVariable String selectCode){
        ModelAndView modelAndView = new ModelAndView("view/currency");
        CodeExchangeRatesTableDTO codeExchangeRatesTableDTO = currencyService.generateLinkFromCode(selectCode);
        ExchangeRatesTable currencyList = currencyService.repository(1L);
        String currency = codeExchangeRatesTableDTO.getCurrency();
        modelAndView.addObject("ratesList", currencyList.getRates());
        modelAndView.addObject("currencyName", currency);
        modelAndView.addObject("codesList", codeExchangeRatesTableDTO.getRates());
        return modelAndView;
    }


    /*@GetMapping("/dto")
    public String todaysResults(Model model) {
        ExchangeRatesTable currencyList = currencyService.return_Object();
        CodeExchangeRatesTableDTO codeExchangeRatesTableDTO = currencyService.returnDailyDto();
        String currency = codeExchangeRatesTableDTO.getCurrency();
        model.addAttribute("ratesList", currencyList.getRates());
        model.addAttribute("currencyName", currency);
        model.addAttribute("codesList", codeExchangeRatesTableDTO.getRates());

        return "view/currency";
    }*/
}

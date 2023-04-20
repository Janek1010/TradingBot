package com.example.tradingbot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
controller 'domowy'  chcialbym aby jakims formsem podawac informacje czy wybierac pary walutowe itp i porzekierowywac na api
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home";
    }
}

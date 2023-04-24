package com.example.tradingbot.controllers;

import com.example.tradingbot.services.SpotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@RequiredArgsConstructor
@Controller
public class SpotController {
    private final SpotService spotService;

    public static final String SPOT_PATH = "/spot";
    public static final String SPOT_PATH_PAIR = SPOT_PATH + "/{pair}";

    @GetMapping(SPOT_PATH_PAIR)
    public String getCryptocurrency(@PathVariable("pair") String pairName ,Model model){
        model.addAttribute("crypto", spotService.getLastPrice(pairName).orElseThrow());
        // tutaj teraz potrzebuje w service metode ktora zczyta mi historyczne dane, obecnie moze byc na sztywno
        return "spotPairView";
    }
}

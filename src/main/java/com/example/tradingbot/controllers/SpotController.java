package com.example.tradingbot.controllers;


import com.example.tradingbot.services.SpotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
@Slf4j
@RequiredArgsConstructor
@RestController
public class SpotController {
    private final SpotService spotService;

    public static final String SPOT_PATH = "/api/spot";
    public static final String SPOT_PATH_PAIR = SPOT_PATH + "/{pair}";

    @GetMapping(value = SPOT_PATH_PAIR)
    public BigDecimal getActualPriceOfCryptocurrency(@PathVariable("pair") String pairName){

        return spotService.getLastPrice(pairName).orElseThrow(() -> new RuntimeException("Last price is not available"));
    }
}

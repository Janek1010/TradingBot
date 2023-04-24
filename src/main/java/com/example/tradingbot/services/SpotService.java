package com.example.tradingbot.services;

import com.example.tradingbot.domain.Cryptocurrency;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Optional;

public interface SpotService {
    Optional<Cryptocurrency> getLastPrice(String pair);
    void addHistoricalDataToCrypto(Cryptocurrency cryptocurrency);
}

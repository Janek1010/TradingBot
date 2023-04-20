package com.example.tradingbot.services;

import java.math.BigDecimal;
import java.util.Optional;

public interface SpotService {
    Optional<BigDecimal> getLastPrice(String pair);
}

package com.example.tradingbot.bootstrap;

import com.example.tradingbot.repositories.CryptocurrencyRepository;
import com.example.tradingbot.repositories.PriceRecordRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final CryptocurrencyRepository cryptocurrencyRepository;
    private final PriceRecordRepository priceRecordRepository;

    public BootstrapData(CryptocurrencyRepository cryptocurrencyRepository, PriceRecordRepository priceRecordRepository) {
        this.cryptocurrencyRepository = cryptocurrencyRepository;
        this.priceRecordRepository = priceRecordRepository;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}

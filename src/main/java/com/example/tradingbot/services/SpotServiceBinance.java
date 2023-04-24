package com.example.tradingbot.services;

import com.example.tradingbot.domain.Cryptocurrency;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

@Service
public class SpotServiceBinance implements SpotService {
    @Override
    public Optional<Cryptocurrency> getLastPrice(String pair) {
        WebClient client = WebClient.create("https://api.binance.com");
        Mono<Map<String, String>> response = client.get()
                .uri("/api/v3/ticker/price?symbol=" + pair.toUpperCase())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, String>>() {});

        Map<String, String> responseBody = response.block();

        return Optional.of(Cryptocurrency.builder()
                .lastPrice(new BigDecimal(responseBody.get("price")))
                .pairName(responseBody.get("symbol"))
                .build());
    }

    @Override
    public void addHistoricalDataToCrypto(Cryptocurrency cryptocurrency)  {
        // aktualnie sprawdzamy dane na sztywno https://github.com/binance/binance-public-data/#trades-1
        // potem ddoac zeby pobieralo
        //  <base_url>/data/spot/monthly/klines/<symbol_in_uppercase>/<interval>/<symbol_in_uppercase>-<interval>-<year>-<month>.zip

        // jak zrobic:
        // dostaje dane interwal, symbol itp.
        // tworze url zgodnie ze wzorem
        // pobieram tego zipa
        // unzipuje
        // otwieram csv w srodku
        // zczytuje dane i dopisuje do podanej crypto
        // returnuje ja


    }
}

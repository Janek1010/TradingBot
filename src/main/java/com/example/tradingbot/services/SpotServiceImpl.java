package com.example.tradingbot.services;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class SpotServiceImpl implements SpotService {
    @Override
    public Optional<BigDecimal> getLastPrice(String pair) {
        WebClient client = WebClient.create("https://api.binance.com");
        Mono<String> response = client.get()
                .uri("/api/v3/ticker/price?symbol=" + pair.toUpperCase())
                .retrieve()
                .bodyToMono(String.class);

        String responseBody = response.block();
        System.out.println(responseBody);

        return Optional.of(new BigDecimal(0.1));
    }

}

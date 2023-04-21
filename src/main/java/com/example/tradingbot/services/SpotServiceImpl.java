package com.example.tradingbot.services;

import com.example.tradingbot.domain.Cryptocurrency;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class SpotServiceImpl implements SpotService {
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

}

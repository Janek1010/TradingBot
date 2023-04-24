package com.example.tradingbot.repositories;

import com.example.tradingbot.domain.Cryptocurrency;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CryptocurrencyRepository extends CrudRepository<Cryptocurrency, UUID> {
}

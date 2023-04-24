package com.example.tradingbot.repositories;

import com.example.tradingbot.domain.Cryptocurrency;
import com.example.tradingbot.domain.PriceRecord;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PriceRecordRepository extends CrudRepository<PriceRecord, UUID> {
}

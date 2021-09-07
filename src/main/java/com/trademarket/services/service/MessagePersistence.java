package com.trademarket.services.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.trademarket.services.dto.request.TradeRequest;
import com.trademarket.services.entity.TradeTransactionEntity;
import com.trademarket.services.repositories.TradeStoreRepository;
import com.trademarket.services.util.MapperUtil;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessagePersistence implements TransactionOperations {
    private TradeStoreRepository tradeStoreRepository;

    public MessagePersistence(TradeStoreRepository tradeStoreRepository){
        this.tradeStoreRepository=tradeStoreRepository;
    }

    @Override
    public void save(TradeRequest tradeRequest) {
        TradeTransactionEntity tradeTransactionEntity=new TradeTransactionEntity(tradeRequest);
        tradeStoreRepository.save(tradeTransactionEntity);
    }
}

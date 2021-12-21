package com.trademarket.services.service;

import com.trademarket.services.dto.request.TradeRequest;
import com.trademarket.services.entity.TradeTransactionEntity;
import com.trademarket.services.exception.CustomException;
import com.trademarket.services.repo.TransactionOperations;
import com.trademarket.services.repositories.TradeStoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MessagePersistenceService implements TransactionOperations {
    private TradeStoreRepository tradeStoreRepository;

    public MessagePersistenceService(TradeStoreRepository tradeStoreRepository){
        this.tradeStoreRepository=tradeStoreRepository;
    }

    @Override
    public void save(TradeRequest tradeRequest) {
        TradeTransactionEntity tradeTransactionEntity=new TradeTransactionEntity(tradeRequest);
        boolean isExist=tradeStoreRepository.checkIfExistAccNo(tradeRequest.getAccountId());
        if(isExist) throw new CustomException("account is exist",500);
        tradeStoreRepository.save(tradeTransactionEntity);
    }


    public void saveWithEntity(TradeTransactionEntity tradeRequest) {
          boolean isExist=tradeStoreRepository.checkIfExistAccNo(tradeRequest.getAccountId());
        if(isExist) throw new CustomException("account is exist",500);
        tradeStoreRepository.save(tradeRequest);
    }

    public List<TradeTransactionEntity> findAllTrades(){
        List<TradeTransactionEntity> entity=tradeStoreRepository.findAll();
        return  entity;
    }

    public TradeTransactionEntity getById(Long id){
        Objects.requireNonNull(id,()->{throw new CustomException("id is null",404);});
        tradeStoreRepository.getByIdFromTable(id);
        return null;
    }


}

package com.trademarket.services.repo;

import com.trademarket.services.dto.request.TradeRequest;
import com.trademarket.services.entity.TradeTransactionEntity;

public interface TransactionOperations {
   void save(TradeRequest tradeRequest);
}

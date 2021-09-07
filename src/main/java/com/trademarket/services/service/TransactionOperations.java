package com.trademarket.services.service;

import com.trademarket.services.dto.request.TradeRequest;

public interface TransactionOperations {
   void save(TradeRequest tradeRequest);
}

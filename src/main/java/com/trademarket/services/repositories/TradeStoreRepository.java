package com.trademarket.services.repositories;

import com.trademarket.services.entity.TradeTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeStoreRepository extends JpaRepository<TradeTransactionEntity,Long> {

}

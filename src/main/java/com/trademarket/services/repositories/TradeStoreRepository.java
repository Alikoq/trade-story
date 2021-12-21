package com.trademarket.services.repositories;

import com.trademarket.services.entity.TradeTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TradeStoreRepository extends JpaRepository<TradeTransactionEntity,Long> {

    @Query("select t from TradeTransactionEntity t where t.id=:id")
    TradeTransactionEntity getByIdFromTable(@Param("id") long id);

    @Query("Select case when count(t)>0 then true else false end from TradeTransactionEntity  t where t.accountId=:accNo")
    Boolean checkIfExistAccNo(@Param("accNo") String accNo);

}

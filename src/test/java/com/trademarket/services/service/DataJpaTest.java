package com.trademarket.services.service;

import com.trademarket.services.dto.request.TradeRequest;
import com.trademarket.services.entity.TradeTransactionEntity;
import com.trademarket.services.repositories.TradeStoreRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
public class DataJpaTest {
    @Autowired
    private TradeStoreRepository tradeStoreRepository;

    @AfterEach
    void tearDown() {
        tradeStoreRepository.deleteAll();
    }

    @Test
    void  checkIfExist(){
        TradeRequest tradeRequest = new TradeRequest();
        tradeRequest.setAccountId("Acc_1");
        tradeRequest.setTradeId(123L);
        tradeRequest.setCreDate("11.12.2021");
        tradeRequest.setExpireDate("12.01.2022");
        tradeRequest.setISIN("ISIN2221");
        tradeRequest.setNumbers(111.0);
        tradeRequest.setSettleDate("13.01.2022");
        tradeRequest.setTradeIdVersion(12);
        TradeTransactionEntity trEntity=new TradeTransactionEntity(tradeRequest);
        tradeStoreRepository.save(trEntity);
        boolean isExist = tradeStoreRepository.checkIfExistAccNo(tradeRequest.getAccountId());
        assertThat(isExist).isTrue();

    }

    @Test
    void checkIfNotExistAccNumber(){
        String accNo="Acc_1";
        boolean check=tradeStoreRepository.checkIfExistAccNo(accNo);
        assertThat(check).isFalse();
    }
    @Test
    void checkIfNotExistAccNo(){
        String accNo="Acc_1";
        boolean doesExist=tradeStoreRepository.checkIfExistAccNo(accNo);
        assertThat(doesExist).isFalse();
    }


}

package com.trademarket.services.service;

import com.trademarket.services.dto.request.TradeRequest;
import com.trademarket.services.entity.TradeTransactionEntity;
import com.trademarket.services.exception.CustomException;
import com.trademarket.services.repositories.TradeStoreRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MessagePersistenceServiceTest {


    private MessagePersistenceService messagePersistenceService;
    @Mock
    private TradeStoreRepository tradeStoreRepository;
 //   private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp(){
       // autoCloseable= MockitoAnnotations.openMocks(this);
        messagePersistenceService=new MessagePersistenceService(tradeStoreRepository);
    }

//    @AfterEach
//    void tearDown() throws Exception{
//        autoCloseable.close();
//    }

    @Test
    void canAdd() {
        //given
        TradeRequest tradeRequest = new TradeRequest();
        tradeRequest.setAccountId("Acc_1");
        tradeRequest.setTradeId(123L);
        tradeRequest.setCreDate("11.12.2021");
        tradeRequest.setExpireDate("12.01.2022");
        tradeRequest.setISIN("ISIN2221");
        tradeRequest.setNumbers(111.0);
        tradeRequest.setSettleDate("13.01.2022");
        tradeRequest.setTradeIdVersion(12);

        //when
        TradeTransactionEntity tradeTransactionEntity=new TradeTransactionEntity(tradeRequest);

        messagePersistenceService.saveWithEntity(tradeTransactionEntity);
        //then
        ArgumentCaptor<TradeTransactionEntity> tradeRequestArgumentCaptor=ArgumentCaptor.forClass(TradeTransactionEntity.class);
        verify(tradeStoreRepository).save(tradeRequestArgumentCaptor.capture());//if save in repository allow this entity
        TradeTransactionEntity capturedTransactionEntity=  tradeRequestArgumentCaptor.getValue();
         assertThat(capturedTransactionEntity).isEqualTo(tradeTransactionEntity );
    }

    @Test
    void willThrowWhenAccExist(){
        //  RuntimeException exception=assertThrows(CustomException.class,()->messagePersistenceService.save(tradeRequest));
        //  assertTrue(exception.getMessage().contains("account is"));
        TradeRequest tradeRequest = new TradeRequest();
        tradeRequest.setAccountId("Acc_1");
        tradeRequest.setTradeId(123L);
        tradeRequest.setCreDate("11.12.2021");
        tradeRequest.setExpireDate("12.01.2022");
        tradeRequest.setISIN("ISIN2221");
        tradeRequest.setNumbers(111.0);
        tradeRequest.setSettleDate("13.01.2022");
        tradeRequest.setTradeIdVersion(12);

        //given
        given(tradeStoreRepository.checkIfExistAccNo(tradeRequest.getAccountId())).willReturn(true);
        //when
        assertThatThrownBy(()->messagePersistenceService.save(tradeRequest)).isInstanceOf(CustomException.class).hasMessageContaining("account is exist");

        verify(tradeStoreRepository,never()).save(any());
    }

    @Test
    @DisplayName("This method retrieve all records from db")
    void getAll(){
        messagePersistenceService.findAllTrades();
        verify(tradeStoreRepository).findAll() ;
    }
    @Test
    void getById() {
    }
}
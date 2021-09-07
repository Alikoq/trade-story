package com.trademarket.services.messaging;

import com.trademarket.services.dto.request.TradeRequest;
import com.trademarket.services.service.ProduceMsgService;
import com.trademarket.services.util.DateParserUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ProduceMsgTest {
    ProduceMsgService produceMsg;
    @Mock
    KafkaTemplate<String, TradeRequest> kafkaTemplate;

    @BeforeEach
    void setup(){
         produceMsg=new ProduceMsgService(kafkaTemplate);
     //   this.kafkaTemplate = new KafkaTemplate<>();
    }
    @Test
    @DisplayName("this test method for verifying is msg  published")
    void testProducer(){
        TradeRequest tradeRequest = new TradeRequest();
        tradeRequest.setAccountId("Acc_1");
        tradeRequest.setTradeId(123L);
        tradeRequest.setCreDate("11.12.2021");
        tradeRequest.setExpireDate("12.01.2022");
        tradeRequest.setISIN("ISIN2221");
        tradeRequest.setNumbers(111.0);
        tradeRequest.setSettleDate("13.01.2022");
        tradeRequest.setTradeIdVersion(12);

         assertEquals(true,produceMsg.publishMessage(tradeRequest));
    }
 }
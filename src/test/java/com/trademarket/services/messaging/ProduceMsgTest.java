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

import java.util.Date;

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
        tradeRequest.setCreDate(DateParserUtil.parseStr("11.12.2021"));
        tradeRequest.setExpireDate(DateParserUtil.parseStr("12.01.2022"));
        tradeRequest.setISIN("ISIN2221");
        tradeRequest.setNumbers(111.0);
        tradeRequest.setSettleDate(DateParserUtil.parseStr("13.01.2022"));
        tradeRequest.setTradeIdVersion(12);

         assertEquals(true,produceMsg.publishMessage(tradeRequest));
    }

}
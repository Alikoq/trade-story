package com.trademarket.services.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.trademarket.services.dto.request.TradeRequest;
import com.trademarket.services.util.MapperUtil;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {
    public MessagePersistence messagePersist;
    public MessageConsumer(MessagePersistence messagePersist){
        this.messagePersist = messagePersist;
    }
    @KafkaListener(topics = "topic_1",groupId = "first_gr")
    public void readMessage(String msg) throws JsonProcessingException {
        if(msg!=null){
            TradeRequest tradeRequest= MapperUtil.convertToObj(msg);
            messagePersist.save(tradeRequest);
        }
    }
}
package com.trademarket.services.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.trademarket.services.dto.request.TradeRequest;
import com.trademarket.services.exception.CustomException;
import com.trademarket.services.util.MapperUtil;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {
    public MessagePersistenceService messagePersist;
    public MessageConsumer(MessagePersistenceService messagePersist){
        this.messagePersist = messagePersist;
    }
    @KafkaListener(topics = "topic_1",groupId = "first_gr")
    public void readMessage(String msg) throws JsonProcessingException {
       try {
           if(msg!=null){
               TradeRequest tradeRequest= MapperUtil.convertToObj(msg);
               messagePersist.save(tradeRequest);
           }
       }catch (Exception ex){
           throw new CustomException("Message coldn't readed",500);
       }

    }

}

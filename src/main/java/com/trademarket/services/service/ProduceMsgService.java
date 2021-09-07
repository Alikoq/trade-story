package com.trademarket.services.service;

import com.trademarket.services.dto.request.TradeRequest;
import com.trademarket.services.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class ProduceMsgService {
    private KafkaTemplate<String, TradeRequest> kafkaTemplate;
    public ProduceMsgService(KafkaTemplate<String,TradeRequest> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public boolean publishMessage(TradeRequest tradeRequest){
        String TOPIC_1 = "topic_1";
        try{
            kafkaTemplate.send(TOPIC_1,tradeRequest);
        }catch (Exception e){
            throw new CustomException("Error during publishing",404);
        }
        return true;
    }


}

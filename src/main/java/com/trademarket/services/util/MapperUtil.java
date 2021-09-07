package com.trademarket.services.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trademarket.services.dto.request.TradeRequest;

public class MapperUtil {

    public static TradeRequest convertToObj(String json) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        TradeRequest tradeRequest= objectMapper.readValue(json,TradeRequest.class);
        return tradeRequest;
    }
}

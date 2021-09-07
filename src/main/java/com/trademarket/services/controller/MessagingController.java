package com.trademarket.services.controller;

import com.trademarket.services.dto.request.TradeRequest;
import com.trademarket.services.service.ProduceMsgService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class MessagingController {
    public final ProduceMsgService produceMsg;
    private MessagingController(ProduceMsgService produceMsg){
        this.produceMsg=produceMsg;
    }
    @PostMapping(value = "/produce-msg")
    public ResponseEntity<String> produceMsg(@RequestBody TradeRequest tradeRequest){
        produceMsg.publishMessage(tradeRequest);
        return new ResponseEntity<>("Successfully published", HttpStatus.ACCEPTED);
    }

}

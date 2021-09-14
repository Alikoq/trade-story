package com.trademarket.services.service;

import com.trademarket.services.repositories.TradeStoreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MessagePersistenceTest {

    @Mock
    private TradeStoreRepository tradeStoreRepository;
    private MessagePersistence messagePersistence;

    @BeforeEach
    void setUp(){
        messagePersistence=new MessagePersistence(tradeStoreRepository);
    }
    @Test
    void save() {
    }
}
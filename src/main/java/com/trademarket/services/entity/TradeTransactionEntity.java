package com.trademarket.services.entity;

import com.trademarket.services.dto.request.TradeRequest;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "trade_transactions")
public class TradeTransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "trade_id_version")
    private Integer tradeIdVersion;
    @Column(name = "cre_date")
    private String creDate;
    @Column(name = "expire_date")
    private String expireDate;
    @Column(name = "account_id")
    private String accountId;
    @Column(name = "trade_date")
    private String tradeDate;
    @Column(name = "settle_date")
    private String settleDate;
    @Column(name = "numbers")
    private Double numbers;
    @Column(name = "ISIN")
    private String isin;

    public TradeTransactionEntity() {

    }

    public TradeTransactionEntity(TradeRequest tradeRequest) {
        this.accountId=tradeRequest.getAccountId();
        this.isin=tradeRequest.getISIN();
        this.tradeDate=tradeRequest.getTradeDate();
        this.expireDate=tradeRequest.getExpireDate();
        this.settleDate=tradeRequest.getSettleDate();
        this.numbers=tradeRequest.getNumbers();
        this.creDate=tradeRequest.getCreDate();
        this.tradeIdVersion=tradeRequest.getTradeIdVersion();


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTradeIdVersion() {
        return tradeIdVersion;
    }

    public void setTradeIdVersion(Integer tradeIdVersion) {
        this.tradeIdVersion = tradeIdVersion;
    }


}

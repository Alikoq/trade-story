package com.trademarket.services.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TradeRequest {
    @JsonProperty("TradeId")
    private Long TradeId;
    @JsonProperty("TradeIdVersion")
    private Integer TradeIdVersion;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd.MM.yyyy")
    @JsonProperty("CreDate")
    private String CreDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd.MM.yyyy")
    private String ExpireDate;
    @JsonProperty("AccountId")
    private String AccountId;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd.MM.yyyy")
    private String TradeDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd.MM.yyyy")
    private String SettleDate;
    @JsonProperty("Numbers")
    private Double Numbers;
    @JsonProperty("ISIN")
    private String ISIN;

    public TradeRequest() {
    }

    public Long getTradeId() {
        return TradeId;
    }

    public void setTradeId(Long tradeId) {
        TradeId = tradeId;
    }

    public Integer getTradeIdVersion() {
        return TradeIdVersion;
    }

    public void setTradeIdVersion(Integer tradeIdVersion) {
        TradeIdVersion = tradeIdVersion;
    }

    public String getCreDate() {
        return CreDate;
    }

    public void setCreDate(String creDate) {
        CreDate = creDate;
    }

    public String getExpireDate() {
        return ExpireDate;
    }

    public void setExpireDate(String expireDate) {
        ExpireDate = expireDate;
    }

    public String getAccountId() {
        return AccountId;
    }

    public void setAccountId(String accountId) {
        AccountId = accountId;
    }

    public String getTradeDate() {
        return TradeDate;
    }

    public void setTradeDate(String tradeDate) {
        TradeDate = tradeDate;
    }

    public String getSettleDate() {
        return SettleDate;
    }

    public void setSettleDate(String settleDate) {
        SettleDate = settleDate;
    }

    public Double getNumbers() {
        return Numbers;
    }

    public void setNumbers(Double numbers) {
        Numbers = numbers;
    }

    public String getISIN() {
        return ISIN;
    }

    public void setISIN(String ISIN) {
        this.ISIN = ISIN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TradeRequest that = (TradeRequest) o;
        return Objects.equals(TradeId, that.TradeId) && Objects.equals(TradeIdVersion, that.TradeIdVersion) && Objects.equals(CreDate, that.CreDate) && Objects.equals(ExpireDate, that.ExpireDate) && Objects.equals(AccountId, that.AccountId) && Objects.equals(TradeDate, that.TradeDate) && Objects.equals(SettleDate, that.SettleDate) && Objects.equals(Numbers, that.Numbers) && Objects.equals(ISIN, that.ISIN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(TradeId, TradeIdVersion, CreDate, ExpireDate, AccountId, TradeDate, SettleDate, Numbers, ISIN);
    }

    @Override
    public String toString() {
        return "TradeRequest{" +
                "TradeId=" + TradeId +
                ", TradeIdVersion=" + TradeIdVersion +
                ", CreDate=" + CreDate +
                ", ExpireDate=" + ExpireDate +
                ", AccountId='" + AccountId + '\'' +
                ", TradeDate=" + TradeDate +
                ", SettleDate=" + SettleDate +
                ", Numbers=" + Numbers +
                ", ISIN='" + ISIN + '\'' +
                '}';
    }
}

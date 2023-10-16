package com.wex.test.domainObj;

import java.time.LocalDateTime;

public class ConvertedPurchase {

    private String id;
    private String description;
    private LocalDateTime transactionDate;
    private Double original_amount;
    private Double converted_amount;
    private Double exchange_rate;
    private String country_currency_desc;

    public ConvertedPurchase(String id, String description, LocalDateTime transactionDate, Double exchange_rate, Double original_amount, Double converted_amount, String country_currency_desc) {
        this.id = id;
        this.description = description;
        this.transactionDate = transactionDate;
        this.original_amount = original_amount;
        this.converted_amount = converted_amount;
        this.exchange_rate = exchange_rate;
        this.country_currency_desc = country_currency_desc;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public Double getOriginal_amount() {
        return original_amount;
    }

    public Double getConverted_amount() {
        return converted_amount;
    }

    public Double getExchange_rate() {
        return exchange_rate;
    }

    public String getCountry_currency_desc() {
        return country_currency_desc;
    }

}

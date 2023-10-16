package com.wex.test.domainObj;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TreasuryResponse {

    @JsonProperty("country_currency_desc")
    private String country_currency_desc;
    @JsonProperty("exchange_rate")
    private String exchange_rate;
    @JsonProperty("record_date")
    private String record_date;

    public TreasuryResponse() {
    }

    public TreasuryResponse(String country_currency_desc, String exchange_rate, String record_date) {
        this.country_currency_desc = country_currency_desc;
        this.exchange_rate = exchange_rate;
        this.record_date = record_date;
    }

    public String getCountry_currency_desc() {
        return country_currency_desc;
    }

    public String getExchange_rate() {
        return exchange_rate;
    }

    public String getRecord_date() {
        return record_date;
    }
}

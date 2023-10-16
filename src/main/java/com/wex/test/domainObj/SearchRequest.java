package com.wex.test.domainObj;

public class SearchRequest {

    private String uuid;
    private String country_currency_desc;
    private String record_date;

    public SearchRequest(String uuid, String country_currency_desc, String record_date) {
        this.uuid = uuid;
        this.country_currency_desc = country_currency_desc;
        this.record_date = record_date;
    }

    public String getUuid() {
        return uuid;
    }

    public String getCountry_currency_desc() {
        return country_currency_desc;
    }

    public String getRecord_date() {
        return record_date;
    }
}

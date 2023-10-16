package com.wex.test.domainObj;

public class RequestResponse {

    private String message;
    private ConvertedPurchase convertedPurchase;

    public RequestResponse() {

    }

    public String getMessage() {
        return message;
    }

    public ConvertedPurchase getConvertedPurchase() {
        return convertedPurchase;
    }

    public void setMessage(String success) {
        this.message = success;
    }

    public void setConvertedPurchase(ConvertedPurchase convertedPurchase) {
        this.convertedPurchase = convertedPurchase;
    }
}

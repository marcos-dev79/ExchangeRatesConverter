package com.wex.test.domainObj;

import io.swagger.v3.oas.annotations.media.Schema;

public class RequestResponse {

    @Schema(description = "Response message", example = "Success")
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

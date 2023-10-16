package com.wex.test.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wex.test.domainObj.*;
import com.wex.test.repositories.PurchaseTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.util.*;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseTransactionRepository purchaseTransactionRepository;

    public PurchaseTransaction save(PurchaseTransaction purchaseTransaction) {
        return purchaseTransactionRepository.save(purchaseTransaction);
    }

    public List<PurchaseTransaction> findAll() {
        return purchaseTransactionRepository.findAll();
    }

    public RequestResponse getConvertedData(SearchRequest searchRequest) throws JsonProcessingException {

        RequestResponse requestResponse = new RequestResponse();

        // Check if it exists first, so we don't need to make a call to the API, saving resources.
        Optional<PurchaseTransaction> opt = purchaseTransactionRepository.findByUuid(searchRequest.getUuid());
        PurchaseTransaction purchaseTransaction;
        if (opt.isPresent()) {
            purchaseTransaction = opt.get();
        } else {
            requestResponse.setMessage("The purchase cannot be found.");
            requestResponse.setConvertedPurchase(null);
            return requestResponse;
        }

        String url = "https://api.fiscaldata.treasury.gov/services/api/fiscal_service/v1/accounting/od/rates_of_exchange?fields=country_currency_desc,exchange_rate,record_date&filter=country_currency_desc:IN:("+ searchRequest.getCountry_currency_desc() +"),record_date:lte:"+searchRequest.getRecord_date()+"&sort=-record_date&format=json";

        LocalDate requestDate = LocalDate.parse(searchRequest.getRecord_date());
        LocalDate monthsago = requestDate.minusMonths(6);

        RestTemplate restTemplate = new RestTemplate();
        String json = restTemplate.getForObject(url, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(json);
        TreasuryResponse[] responsesArr = objectMapper.readValue(jsonNode.get("data").toString(), TreasuryResponse[].class);
        List<TreasuryResponse> treasuryResponses = new ArrayList(Arrays.asList(responsesArr));
        TreasuryResponse response = treasuryResponses.get(0);

        DecimalFormat df = new DecimalFormat("#.##");
        df.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        df.setRoundingMode(RoundingMode.UP);

        if(response != null) {
            LocalDate responseDate = LocalDate.parse(response.getRecord_date());
            if (responseDate.isBefore(monthsago)) {
                requestResponse.setMessage("The purchase cannot be converted to the target currency.");
                requestResponse.setConvertedPurchase(null);
            }else {
                ConvertedPurchase convertedPurchase = new ConvertedPurchase(
                        searchRequest.getUuid(),
                        purchaseTransaction.getDescription(),
                        purchaseTransaction.getTransactionDate(),
                        Double.valueOf(response.getExchange_rate()),
                        Double.valueOf(df.format(purchaseTransaction.getAmount())),
                        Double.valueOf(df.format(purchaseTransaction.getAmount() * Double.valueOf(response.getExchange_rate()))),
                        response.getCountry_currency_desc()
                );

                requestResponse.setMessage("Success");
                requestResponse.setConvertedPurchase(convertedPurchase);
            }

        }

        return requestResponse;
    }

}

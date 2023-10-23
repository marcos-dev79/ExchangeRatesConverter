package com.wex.test.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wex.test.domainObj.PurchaseTransaction;
import com.wex.test.domainObj.RequestResponse;
import com.wex.test.domainObj.SearchRequest;
import com.wex.test.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "purchaseTransaction")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping(path = "/all")
    public List<PurchaseTransaction> getAll() {
        return purchaseService.findAll();
    }

    @PostMapping("/save")
    public PurchaseTransaction save(@RequestBody PurchaseTransaction purchaseTransaction) {
        return purchaseService.save(purchaseTransaction);
    }

    @PostMapping("/convert")
    public RequestResponse convert(@RequestBody SearchRequest searchRequest) throws JsonProcessingException {
        RequestResponse requestResponse = purchaseService.getConvertedData(searchRequest);
        return requestResponse;
    }
}

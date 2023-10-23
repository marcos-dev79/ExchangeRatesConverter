package com.wex.test.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wex.test.domainObj.PurchaseTransaction;
import com.wex.test.domainObj.RequestResponse;
import com.wex.test.domainObj.SearchRequest;
import com.wex.test.services.PurchaseService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "purchaseTransaction")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping(path = "/all")
    @Tag(
        name = "Purchase Transaction",
        description = "Operations on purchase transactions"
    )
    @Operation(
        summary = "Get all operations",
        description = "Retrieve all operation in the system without any filter or sorting"
    )
    public List<PurchaseTransaction> getAll() {
        return purchaseService.findAll();
    }

    @PostMapping("/save")
    @Tag(
        name = "Purchase Transaction"
    )
    @Operation(
        summary = "Save a transaction",
        description = "Receives a transaction, saves it in the database and return the given object"
    )
    public PurchaseTransaction save(@RequestBody PurchaseTransaction purchaseTransaction) {
        return purchaseService.save(purchaseTransaction);
    }

    @PostMapping("/convert")
    @Tag(
        name = "Purchase Transaction"
    )
    @Operation(
        summary = "Convert transaction",
        description = "Perform the convertion of a given transaction"
    )
    public RequestResponse convert(@RequestBody SearchRequest searchRequest) throws JsonProcessingException {
        RequestResponse requestResponse = purchaseService.getConvertedData(searchRequest);
        return requestResponse;
    }
}

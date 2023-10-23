package com.wex.test.domainObj;

import java.time.LocalDateTime;
import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;

public record ConvertedPurchase (
    @Schema(description = "Purchase transaction ID", example = "a42dbe56-2660-4ee4-b439-4b976a2e06d9")
    UUID id,
    @Schema(description = "Purchase description", example = "Purchase transaction Test")
    String description,
    @Schema(description = "Date of transaction", example = "2018-12-31T17:18")
    LocalDateTime transactionDate,
    @Schema(description = "Original amount of purchase", example = "15.3")
    Double originalAmount,
    @Schema(description = "Converted amount of purchase", example = "13.35")
    Double convertedAmount,
    @Schema(description = "Rate used to convert", example = "0.872")
    Double exchangeRate,
    @Schema(description = "Description of currency", example = "GERMANY-EURO")
    String countryCurrencyDesc
){}

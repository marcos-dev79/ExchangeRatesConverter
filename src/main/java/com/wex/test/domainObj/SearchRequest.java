package com.wex.test.domainObj;

import java.time.LocalDate;
import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;

public record SearchRequest (
    @Schema(description = "Purchase transaction ID", example = "a42dbe56-2660-4ee4-b439-4b976a2e06d9", requiredMode = Schema.RequiredMode.REQUIRED)
    UUID uuid,
    @Schema(description = "Description of currency", example = "GERMANY-EURO", requiredMode = Schema.RequiredMode.REQUIRED)
    String countryCurrencyDesc,
    @Schema(description = "Record date", example = "2018-12-31", requiredMode = Schema.RequiredMode.REQUIRED)
    LocalDate recordDate
){}

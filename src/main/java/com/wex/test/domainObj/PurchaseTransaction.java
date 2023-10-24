package com.wex.test.domainObj;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.UUID;

@Document(collection = "purchaseTransaction")
public class PurchaseTransaction {
    @Field(value = "uuid", targetType = FieldType.STRING)
    @Schema(description = "Purchase transaction ID", example = "a42dbe56-2660-4ee4-b439-4b976a2e06d9", requiredMode = Schema.RequiredMode.REQUIRED)
    private UUID uuid;

    @Field(value = "description", targetType = FieldType.STRING)
    @Schema(description = "Purchase description", example = "Purchase transaction Test", requiredMode = Schema.RequiredMode.REQUIRED)
    private String description;

    @Field(value = "transactionDate", targetType = FieldType.DATE_TIME)
    @Schema(description = "Date of transaction", example = "2018-12-31T17:18", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime transactionDate;

    @Field(value = "amount", targetType = FieldType.DOUBLE)
    @Schema(description = "Amount of the transaction", example = "15.30", requiredMode = Schema.RequiredMode.REQUIRED)
    private Double amount;

    public PurchaseTransaction() {
    }

    public PurchaseTransaction(String description, LocalDateTime transactionDate, Double amount) {
        this.uuid = UUID.randomUUID();
        this.description = description;
        this.transactionDate = transactionDate;
        this.amount = amount;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID id) {
        this.uuid = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}

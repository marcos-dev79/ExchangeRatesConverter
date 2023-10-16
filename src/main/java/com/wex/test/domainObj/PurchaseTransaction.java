package com.wex.test.domainObj;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.time.LocalDateTime;
import java.util.UUID;

@Document(collection = "purchaseTransaction")
public class PurchaseTransaction {
    @Field(value = "uuid", targetType = FieldType.STRING)
    private UUID uuid;

    @Field(value = "description", targetType = FieldType.STRING)
    private String description;

    @Field(value = "transactionDate", targetType = FieldType.DATE_TIME)
    private LocalDateTime transactionDate;

    @Field(value = "amount", targetType = FieldType.DOUBLE)
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

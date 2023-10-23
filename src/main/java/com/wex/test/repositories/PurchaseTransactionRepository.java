package com.wex.test.repositories;


import com.wex.test.domainObj.PurchaseTransaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PurchaseTransactionRepository extends MongoRepository<PurchaseTransaction, String> {
    public List<PurchaseTransaction> findAll();
    public Optional<PurchaseTransaction> findByUuid(String id);
}

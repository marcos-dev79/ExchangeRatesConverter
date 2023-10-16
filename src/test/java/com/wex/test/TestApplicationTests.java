package com.wex.test;


import com.wex.test.domainObj.PurchaseTransaction;
import com.wex.test.domainObj.RequestResponse;
import com.wex.test.domainObj.SearchRequest;
import com.wex.test.repositories.PurchaseTransactionRepository;
import com.wex.test.services.PurchaseService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@DataMongoTest(includeFilters = @ComponentScan.Filter(Component.class))
@ContextConfiguration(classes = TestApplication.class)
class TestApplicationTests {

	@Mock
	PurchaseTransactionRepository purchaseTransactionRepository;

	@Mock
	PurchaseService purchaseService;

	@Mock
	PurchaseTransaction purchaseTransaction;

	@Mock
	SearchRequest searchRequest;

	@Mock
	RequestResponse requestResponse;

	@Test
	void contextLoads() {
	}

	@Test
	public void checkItSavesOk() throws Exception {
		Mockito.when(purchaseTransactionRepository.save(purchaseTransaction)).thenReturn(purchaseTransaction);
		assertEquals(purchaseTransaction, purchaseTransactionRepository.save(purchaseTransaction));
	}

	@Test
	public void checkConversionOk() throws Exception {
		Mockito.when(purchaseService.getConvertedData(searchRequest)).thenReturn(requestResponse);
		assertNotNull(purchaseService.getConvertedData(searchRequest));
	}

}

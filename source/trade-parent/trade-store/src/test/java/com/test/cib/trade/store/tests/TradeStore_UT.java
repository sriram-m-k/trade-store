package com.test.cib.trade.store.tests;

import com.test.cib.trade.store.app.TradeStoreApplication;
import com.test.cib.trade.store.data.entity.TradeStoreEntity;
import com.test.cib.trade.store.repository.TradeStoreRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TradeStoreApplication.class)
@ActiveProfiles("test")
public class TradeStore_UT {

@Autowired
TradeStoreRepository tradeStoreRepository;


/**
 * Test validates by inserting data to the table. Validates if table exists
 * and able to insert record
 */
	@Test
	@Sql(scripts = "classpath:data.sql")
	public void testValidateToCheckIfTableCreated()   {
		assertEquals("Data Successfully loaded ",4, tradeStoreRepository.findAll().size());

	}

	/**
	 * Test validates by inserting data to the table.
	 */
	@Test
	public void testIfNewRecordInserts()   {

		TradeStoreEntity entity = insertNewRecord();
		assertEquals("New Record Successfully Added " + entity.getId(),1, tradeStoreRepository.findAll().size());

	}


	private TradeStoreEntity insertNewRecord()   {
		TradeStoreEntity entity = new TradeStoreEntity();
		entity.setBookId("B2");
		entity.setCounterPartyId("CP-1");
		entity.setTradeId("T3");
		Calendar calendar = Calendar.getInstance();
		calendar.set(2022,10,21);
		entity.setMaturityDate(calendar.getTime());
		entity.setCreatedDate((Calendar.getInstance()).getTime());
		entity.setExpired(false);
		entity= tradeStoreRepository.save(entity);
		return entity;
	}

}

package com.test.cib.trade.store.tests;


import com.test.cib.trade.store.api.TradeStoreScheduler;
import com.test.cib.trade.store.app.TradeStoreApplication;
import com.test.cib.trade.store.data.entity.TradeStoreEntity;
import com.test.cib.trade.store.repository.TradeStoreRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TradeStoreApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class TradeStoreScheduler_IT {

	@Autowired
	private TradeStoreScheduler scheduler;

	@Autowired
	private TradeStoreRepository repository;
	@Test
	@Sql("classpath:data_tobe_expired.sql")
	public void testForUpdateOfExpiredRecords()	{
		scheduler.expireRecords();
		List<TradeStoreEntity> entityList=	repository.findAll();
		int count =0;
		if(entityList!=null && entityList.size()!=0)	{

			for(TradeStoreEntity entity: entityList)	{
				if(entity.isExpired())	{
					count++;
				}
			}
		}
		assertEquals(3,count);
	}

	@Test
	@Sql("classpath:data.sql")
	public void testForNoExpiredRecords()	{
		scheduler.expireRecords();
		List<TradeStoreEntity> entityList=	repository.findAll();
		int count =0;
		if(entityList!=null && entityList.size()!=0)	{

			for(TradeStoreEntity entity: entityList)	{
				if(entity.isExpired())	{
					count++;
				}
			}
		}
		assertEquals(0,count);
	}
}

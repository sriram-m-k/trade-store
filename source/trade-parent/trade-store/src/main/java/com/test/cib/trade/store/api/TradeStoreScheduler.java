/*
 * Copyright 2020 by Sriram . All rights reserved.
 * All information contained herein is proprietary and confidential to Sriram .
 *  Any use, reproduction, or disclosure without the written permission of Sriram . is prohibited.
 */
package com.test.cib.trade.store.api;

import com.test.cib.trade.store.data.entity.TradeStoreEntity;
import com.test.cib.trade.store.repository.TradeStoreRepository;
import org.apache.logging.log4j.core.util.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

/**
 *  Schedules the job for updating the status as expired for
 *  trades which has maturity date less than current date.
 *
 * @author  Sriram M.K
 */
public class TradeStoreScheduler {

	Logger logger = LoggerFactory.getLogger(TradeStoreScheduler.class);
	@Autowired
	private TradeStoreRepository repository;

	/**
	 * Schedules the job @ 20:00 Hrs as EOD process.
	 */
	@Scheduled(cron = "0 0 20 * * ?")
	public void expireRecords()	{

		try	{
			List<TradeStoreEntity> entityList = repository.getAllWithMaturityLessThanCD();

				if(!Assert.isEmpty(entityList)) {
					for(TradeStoreEntity entity :entityList)		{
						entity.setExpired(true);
						repository.save(entity);

					}
				}

		} catch(Exception exp)	{
			logger.error("Failed to  update records to expiry",exp);
		}

	}
}

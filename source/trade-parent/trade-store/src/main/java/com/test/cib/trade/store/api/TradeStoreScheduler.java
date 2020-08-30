/*********************************************************************
 Copyright [2020] [Sriram M.K]

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 *********************************************************************/
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

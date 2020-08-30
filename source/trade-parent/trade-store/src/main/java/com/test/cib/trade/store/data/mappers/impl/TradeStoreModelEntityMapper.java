
/*
 * Copyright 2020 by Sriram . All rights reserved.
 * All information contained herein is proprietary and confidential to Sriram .
 *  Any use, reproduction, or disclosure without the written permission of Sriram . is prohibited.
 */
package com.test.cib.trade.store.data.mappers.impl;
import com.test.cib.trade.store.data.entity.TradeStoreEntity;
import com.test.cib.trade.store.data.models.TradeStoreModel;
import com.test.cib.commons.data.mapper.IMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

@Configuration
@Qualifier("tradeStoreMapper")
public class TradeStoreModelEntityMapper implements IMapper<TradeStoreModel, TradeStoreEntity> {
	@Override
	public TradeStoreModel getModelFromEntity(TradeStoreEntity tradeStoreEntity) {
		TradeStoreModel model = null;
		if(tradeStoreEntity !=null )	{
			model = new TradeStoreModel(tradeStoreEntity.getId(),tradeStoreEntity.getCreatedDate(),tradeStoreEntity.isExpired());
			model.setBookId(tradeStoreEntity.getBookId());
			model.setTradeId(tradeStoreEntity.getTradeId());
			model.setCounterPartyId(tradeStoreEntity.getCounterPartyId());
			model.setVersion(tradeStoreEntity.getVersion());
			model.setMaturityDate(tradeStoreEntity.getMaturityDate());

		}
		return model;
	}

	@Override
	public TradeStoreEntity getEntityFromModel(TradeStoreModel tradeStoreModel) {
		TradeStoreEntity entity = null;
		if(tradeStoreModel!=null)	{
			entity = new TradeStoreEntity();
			entity.setId(tradeStoreModel.getId());
			entity.setTradeId(tradeStoreModel.getTradeId());
			entity.setVersion(tradeStoreModel.getVersion());
			entity.setBookId(tradeStoreModel.getBookId());
			entity.setCreatedDate(tradeStoreModel.getCreatedDate());
			entity.setCounterPartyId(tradeStoreModel.getCounterPartyId());
			entity.setMaturityDate(tradeStoreModel.getMaturityDate());
			entity.setExpired(tradeStoreModel.isExpired());
		}
		return entity;
	}
}

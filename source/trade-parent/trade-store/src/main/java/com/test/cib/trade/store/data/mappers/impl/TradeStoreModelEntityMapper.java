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

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
package com.test.cib.trade.store.repository;

import com.test.cib.trade.store.data.entity.TradeStoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface  TradeStoreRepository extends JpaRepository<TradeStoreEntity,Long>{
	@Query("SELECT t FROM TradeStoreEntity t WHERE tradeId = :tradeId AND bookId=:bookId and counterPartyId=:counterPartyId")
	public List<TradeStoreEntity> findByUniqueFields(@Param("tradeId") String tradeId, @Param("bookId") String bookId, @Param("counterPartyId") String counterParty);

	@Query("SELECT t FROM TradeStoreEntity t WHERE maturityDate < CURRENT_DATE")
	public List<TradeStoreEntity> getAllWithMaturityLessThanCD();
}

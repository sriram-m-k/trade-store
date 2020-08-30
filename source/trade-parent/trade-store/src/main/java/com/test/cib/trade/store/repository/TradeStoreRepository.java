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

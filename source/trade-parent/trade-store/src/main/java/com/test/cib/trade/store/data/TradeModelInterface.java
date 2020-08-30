/*
 * Copyright 2020 by Sriram . All rights reserved.
 * All information contained herein is proprietary and confidential to Sriram .
 *  Any use, reproduction, or disclosure without the written permission of Sriram . is prohibited.
 */
package com.test.cib.trade.store.data;
import com.test.cib.commons.data.ModelInterface;
import java.util.Date;

/**
 *  Common Trade Store interface used by model and entity
 *
 */
public interface TradeModelInterface extends ModelInterface {


	Long getId();

	String getTradeId();

	void setTradeId(String tradeId);

	int getVersion();

	void setVersion(int version);

	String getCounterPartyId();

	void setCounterPartyId(String counterPartyId);

	String getBookId();

	void setBookId(String bookId);

	Date getMaturityDate();

	void setMaturityDate(Date maturityDate);

	Date getCreatedDate();

	boolean isExpired();


}

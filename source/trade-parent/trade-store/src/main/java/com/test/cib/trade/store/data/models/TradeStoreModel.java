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
package com.test.cib.trade.store.data.models;

import com.test.cib.trade.store.data.TradeModelInterface;

import java.util.Date;


public class TradeStoreModel implements TradeModelInterface {


	private Long id;

	private String tradeId;


	private int version;


	private String counterPartyId;

	private String bookId;

	private Date maturityDate;

	private Date createdDate;
	private boolean expiredStatus;


	public TradeStoreModel() {
	}

	public TradeStoreModel(Long id, Date createdDate, boolean expiredStatus) {
		this.id = id;
		this.createdDate = createdDate;
		this.expiredStatus = expiredStatus;

	}

	@Override
	public Long getId() {
		return null;
	}

	@Override
	public String getTradeId() {
		return tradeId;
	}

	@Override
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	@Override
	public int getVersion() {
		return version;
	}

	@Override
	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String getCounterPartyId() {
		return counterPartyId;
	}

	@Override
	public void setCounterPartyId(String counterPartyId) {
		this.counterPartyId = counterPartyId;
	}

	@Override
	public String getBookId() {
		return bookId;
	}

	@Override
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	@Override
	public Date getMaturityDate() {
		return maturityDate;
	}


	@Override
	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	@Override
	public Date getCreatedDate() {
		return createdDate;
	}

	@Override
	public boolean isExpired() {
		return expiredStatus;
	}


}

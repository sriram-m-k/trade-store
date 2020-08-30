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

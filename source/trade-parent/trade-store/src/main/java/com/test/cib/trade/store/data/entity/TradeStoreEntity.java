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

package com.test.cib.trade.store.data.entity;

import com.test.cib.trade.store.data.TradeModelInterface;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This is the entity class for trade store. Mapped to the table
 * trade_store . Self managed entity creation during start up
 *
 * @author Sriram M.K
 */

@Table(name = "trade_store",
		uniqueConstraints =
		@UniqueConstraint(columnNames = {"trade_id", "version", "cp_id", "book_id"})
)
@Entity
public class TradeStoreEntity implements TradeModelInterface {

	@GeneratedValue
	@Id
	private Long id;


	@Column(name = "trade_id", nullable = false)
	private String tradeId;

	@Column(name = "version", nullable = false)
	private int version;

	@Column(name = "cp_id", nullable = false)
	private String counterPartyId;

	@Column(name = "book_id", nullable = false)
	private String bookId;

	@Column(name = "maturity_date", nullable = false)
	private Date maturityDate;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false)
	private Date createdDate;

	@Column(name = "expired", nullable = false)
	private boolean expiredStatus;

	@PrePersist
	protected void onCreate() throws InstantiationException {

		//prefer database time. Currently trying to use
		// util date time.

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			createdDate = sdf.parse(sdf.format(new Date()));


		} catch (ParseException e) {
			throw new InstantiationException("Could not instantiate");
		}

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public boolean isExpired() {
		return expiredStatus;
	}

	public void setExpired(boolean expiredStatus) {
		this.expiredStatus = expiredStatus;
	}
}

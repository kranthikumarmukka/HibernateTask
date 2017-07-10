package com.hibernate.model.onetoone;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Stock implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long stockId;
	private String stockCode;
	private String stockName;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="stock")
	private StockDetail stockDetail;
	
	public StockDetail getStockDetail() {
		return stockDetail;
	}
	
	public void setStockDetail(StockDetail stockDetail) {
		this.stockDetail = stockDetail;
	}

	public Long getStockId() {
		return stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

}

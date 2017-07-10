package com.hibernate.model.onetoone;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class StockDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@GenericGenerator(name="generator",strategy="foreign",parameters=@Parameter(name="property",value="stock"))
	@Id
	@GeneratedValue(generator="generator")
	private Long stockId;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Stock stock;
	private String companyName;
	private String companyDesc;
	private String remark;
	private LocalDateTime listedDateTime;

	public Long getStockId() {
		return stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyDesc() {
		return companyDesc;
	}

	public void setCompanyDesc(String companyDesc) {
		this.companyDesc = companyDesc;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public LocalDateTime getListedDateTime() {
		return listedDateTime;
	}

	public void setListedDateTime(LocalDateTime listedDateTime) {
		this.listedDateTime = listedDateTime;
	}

}

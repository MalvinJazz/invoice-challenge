package com.invoice.challenge.model;

import java.sql.Time;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name="invoice_detail")
public class InvoiceDetail {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String product;
	private int quantity;
	private float price;
	
	private int invoiceId;
	
	@CreatedDate
	@Column(insertable = false, updatable = false)
	private Time creationDate;
	@LastModifiedDate
	@Column(insertable = false, updatable = false)
	private Time modificationDate;
	
	@Version
	private int version;
	
	public InvoiceDetail() {
		
	}

	public InvoiceDetail(Integer id, String product, int quantity, float price, Integer invoiceId, Time creationDate,
			Time modificationDate) {
		super();
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
		this.invoiceId = invoiceId;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Integer getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Time getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Time creationDate) {
		this.creationDate = creationDate;
	}

	public Time getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Time modificationDate) {
		this.modificationDate = modificationDate;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
}

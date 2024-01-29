package com.invoice.challenge.controller.v1.dto;

import java.io.Serializable;
import java.util.Date;

public class InvoiceDetailDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2987986653973613497L;

	private Integer id;

	private String product;
	private int quantity;
	private float price;

	private int invoiceId;

	private Date creationDate;

	private Date modificationDate;

	public InvoiceDetailDto() {

	}

	public InvoiceDetailDto(Integer id, String product, int quantity, float price, int invoiceId, Date creationDate,
			Date modificationDate) {
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

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

}

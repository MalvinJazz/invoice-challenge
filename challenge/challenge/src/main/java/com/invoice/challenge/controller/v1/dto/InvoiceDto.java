package com.invoice.challenge.controller.v1.dto;

import java.io.Serializable;
import java.util.Date;

public class InvoiceDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 578506568609011146L;
	private Integer id;
	private String client;
	private String taxId;
	private float total;
	private Date creationDate;
	private Date modificationDate;
	private Date deletionDate;
	
	public InvoiceDto(Integer id, String client, String taxId, float total, Date creationDate, Date modificationDate,
			Date deletionDate) {
		super();
		this.id = id;
		this.client = client;
		this.taxId = taxId;
		this.total = total;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
		this.deletionDate = deletionDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getTaxId() {
		return taxId;
	}
	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
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
	public Date getDeletionDate() {
		return deletionDate;
	}
	public void setDeletionDate(Date deletionDate) {
		this.deletionDate = deletionDate;
	}
	
}

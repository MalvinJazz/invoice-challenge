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
@Table(name="invoice")
public class Invoice {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String client;
	private String taxId;
	private float total;
	
	@CreatedDate
	@Column(insertable = false, updatable = false)
	private Time creationDate;
	@LastModifiedDate
	@Column(insertable = false, updatable = false)
	private Time modificationDate;
	private Time deletionDate;
	
	@Version
	private int version;
	
	public Invoice() {
		
	}

	public Invoice(Integer id, String client, String taxId, float total, Time creationDate, Time modificationDate) {
		this.id = id;
		this.client = client;
		this.taxId = taxId;
		this.total = total;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
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

	public Time getDeletionDate() {
		return deletionDate;
	}

	public void setDeletionDate(Time deletionDate) {
		this.deletionDate = deletionDate;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
}

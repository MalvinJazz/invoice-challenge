package com.invoice.challenge.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.invoice.challenge.model.InvoiceDetail;

@Repository
public interface InvoiceDetailDao extends CrudRepository<InvoiceDetail, Integer> {

	public Iterable<InvoiceDetail> findByInvoiceId(Integer invoiceId);
	
}

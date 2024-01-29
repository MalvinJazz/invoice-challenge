package com.invoice.challenge.service;

import com.invoice.challenge.exception.ResourceNotFoundException;
import com.invoice.challenge.model.InvoiceDetail;

public interface InvoiceDetailService {

	public Iterable<InvoiceDetail> list();
	public Iterable<InvoiceDetail> findByInvoiceId(Integer invoiceId);
	public InvoiceDetail find(Integer id) throws ResourceNotFoundException;
	public void save(InvoiceDetail detail);
	public void update(InvoiceDetail detail);
	public void delete(InvoiceDetail detail);
	
}

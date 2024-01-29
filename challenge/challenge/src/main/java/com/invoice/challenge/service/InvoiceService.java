package com.invoice.challenge.service;

import com.invoice.challenge.exception.ResourceNotFoundException;
import com.invoice.challenge.model.Invoice;

public interface InvoiceService {

	public Iterable<Invoice> list();
	public Invoice find(Integer id) throws ResourceNotFoundException;
	public void save(Invoice invoice);
	public void update(Invoice invoice);
	public void delete(Invoice invoice);
	
}

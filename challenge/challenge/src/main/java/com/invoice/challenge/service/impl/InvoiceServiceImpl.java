package com.invoice.challenge.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoice.challenge.dao.InvoiceDao;
import com.invoice.challenge.exception.ResourceNotFoundException;
import com.invoice.challenge.model.Invoice;
import com.invoice.challenge.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {
	
	@Autowired
	private InvoiceDao invoiceDao;

	@Override
	public Iterable<Invoice> list() {
		return invoiceDao.findAll();
	}

	@Override
	public Invoice find(Integer id) throws ResourceNotFoundException {
		
		return invoiceDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException());
	}

	@Override
	public void save(Invoice invoice) {
		
		invoiceDao.save(invoice);

	}

	@Override
	public void update(Invoice invoice) {
		
		invoiceDao.save(invoice);

	}

	@Override
	public void delete(Invoice invoice) {

		invoiceDao.delete(invoice);
		
	}

}

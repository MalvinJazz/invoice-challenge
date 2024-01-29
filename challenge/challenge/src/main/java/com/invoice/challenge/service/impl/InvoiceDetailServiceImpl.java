package com.invoice.challenge.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoice.challenge.dao.InvoiceDetailDao;
import com.invoice.challenge.exception.ResourceNotFoundException;
import com.invoice.challenge.model.InvoiceDetail;
import com.invoice.challenge.service.InvoiceDetailService;

@Service
public class InvoiceDetailServiceImpl implements InvoiceDetailService {

	@Autowired
	private InvoiceDetailDao invoiceDetailDao;
	
	@Override
	public Iterable<InvoiceDetail> list() {
		return invoiceDetailDao.findAll();
	}

	@Override
	public Iterable<InvoiceDetail> findByInvoiceId(Integer invoiceId) {
		return invoiceDetailDao.findByInvoiceId(invoiceId);
	}

	@Override
	public InvoiceDetail find(Integer id) throws ResourceNotFoundException {
		return invoiceDetailDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException());
	}

	@Override
	public void save(InvoiceDetail detail) {
		invoiceDetailDao.save(detail);
	}

	@Override
	public void update(InvoiceDetail detail) {
		invoiceDetailDao.save(detail);
	}

	@Override
	public void delete(InvoiceDetail detail) {
		invoiceDetailDao.delete(detail);
	}

}

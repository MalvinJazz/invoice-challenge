package com.invoice.challenge.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.invoice.challenge.model.Invoice;

@Repository
public interface InvoiceDao extends CrudRepository<Invoice, Integer> {

}

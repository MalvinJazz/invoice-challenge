package com.invoice.challenge.controller.v1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.invoice.challenge.controller.v1.dto.InvoiceDto;
import com.invoice.challenge.exception.ResourceNotFoundException;
import com.invoice.challenge.model.Invoice;
import com.invoice.challenge.service.InvoiceService;

@RestController
@RequestMapping("/v1/invoice")
@CrossOrigin(origins = "http://localhost:3000")
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;
	
	@GetMapping
	public Collection<InvoiceDto> getAllInvoices() {
		
		Iterable<Invoice> rawInvoices = invoiceService.list();
		
		Collection<InvoiceDto> invoicesResponse = new ArrayList<InvoiceDto>();

		Iterator<Invoice> iterator = rawInvoices.iterator();
		
		while(iterator.hasNext()) {
			
			Invoice rawInvoice = iterator.next();
			invoicesResponse.add(
					new InvoiceDto(
							rawInvoice.getId(),
							rawInvoice.getClient(),
							rawInvoice.getTaxId(),
							rawInvoice.getTotal(),
							rawInvoice.getCreationDate(),
							rawInvoice.getModificationDate(),
							rawInvoice.getDeletionDate()
					)
				);
		}
		
		return invoicesResponse;
		
	}
	
	@GetMapping("/{id}")
	@ExceptionHandler(ResourceNotFoundException.class)
	public InvoiceDto getById(@PathVariable("id") Integer id) {
		
		Invoice rawInvoice = invoiceService.find(id);
		
		return new InvoiceDto(
				rawInvoice.getId(),
				rawInvoice.getClient(),
				rawInvoice.getTaxId(),
				rawInvoice.getTotal(),
				rawInvoice.getCreationDate(),
				rawInvoice.getModificationDate(),
				rawInvoice.getDeletionDate()
		);
		
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED) 
	public void saveInvoice(@RequestBody InvoiceDto invoice) {
		
		invoiceService.save(new Invoice(
				Integer.valueOf(0),
				invoice.getClient(),
				invoice.getTaxId(),
				invoice.getTotal(),
				null,
				null
			)
		);
		
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT) 
	public void updateInvoice(@PathVariable("id") Integer id, @RequestBody InvoiceDto invoice) {
		
		invoiceService.save(new Invoice(
				id,
				invoice.getClient(),
				invoice.getTaxId(),
				invoice.getTotal(),
				null,
				null
			)
		);
		
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT) 
	public void deleteInvoice(@PathVariable("id") Integer id) {
		
		Invoice invoiceToDelete = new Invoice();
		invoiceToDelete.setId(id);
		
		invoiceService.delete(invoiceToDelete);
		
	}
	
}

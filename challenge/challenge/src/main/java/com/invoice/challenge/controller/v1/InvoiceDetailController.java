package com.invoice.challenge.controller.v1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.invoice.challenge.controller.v1.dto.InvoiceDetailDto;
import com.invoice.challenge.exception.ResourceNotFoundException;
import com.invoice.challenge.model.InvoiceDetail;
import com.invoice.challenge.service.InvoiceDetailService;

@RestController
@RequestMapping("/v1/invoice/detail")
@CrossOrigin(origins = "http://localhost:3000")
public class InvoiceDetailController {

	@Autowired
	private InvoiceDetailService detailService;
	
	@GetMapping
	public Collection<InvoiceDetailDto> getAllDetails(@RequestParam("invoiceId") Integer invoiceId) {
		
		Iterable<InvoiceDetail> rawDetails = Collections.emptyList();
		if(invoiceId == null || invoiceId == 0) {
			rawDetails = detailService.list();
		} else {
			rawDetails = detailService.findByInvoiceId(invoiceId);
		}
		
		
		Collection<InvoiceDetailDto> detailsResponse = new ArrayList<InvoiceDetailDto>();

		Iterator<InvoiceDetail> iterator = rawDetails.iterator();
		
		while(iterator.hasNext()) {
			
			InvoiceDetail rawDetail = iterator.next();
			detailsResponse.add(
					new InvoiceDetailDto(
							rawDetail.getId(),
							rawDetail.getProduct(),
							rawDetail.getQuantity(),
							rawDetail.getPrice(),
							rawDetail.getInvoiceId(),
							rawDetail.getCreationDate(),
							rawDetail.getModificationDate()
					)
				);
		}
		
		return detailsResponse;
		
	}
	
	@GetMapping("/{id}")
	@ExceptionHandler(ResourceNotFoundException.class)
	public InvoiceDetailDto getById(@PathVariable("id") Integer id) {
		
		InvoiceDetail rawDetail = detailService.find(id);
		
		return new InvoiceDetailDto(
				rawDetail.getId(),
				rawDetail.getProduct(),
				rawDetail.getQuantity(),
				rawDetail.getPrice(),
				rawDetail.getInvoiceId(),
				rawDetail.getCreationDate(),
				rawDetail.getModificationDate()
		);
		
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED) 
	public void saveDetail(@RequestBody InvoiceDetailDto detail) {
		
		detailService.save(new InvoiceDetail(
				Integer.valueOf(0),
				detail.getProduct(),
				detail.getQuantity(),
				detail.getPrice(),
				detail.getInvoiceId(),
				null,
				null
			)
		);
		
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT) 
	public void updateDetail(@PathVariable("id") Integer id, @RequestBody InvoiceDetailDto detail) {
		
		detailService.save(new InvoiceDetail(
				id,
				detail.getProduct(),
				detail.getQuantity(),
				detail.getPrice(),
				detail.getInvoiceId(),
				null,
				null
			)
		);
		
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT) 
	public void deleteDetail(@PathVariable("id") Integer id) {
		
		InvoiceDetail detailToDelete = new InvoiceDetail();
		detailToDelete.setId(id);
		
		detailService.delete(detailToDelete);
		
	}
	
}

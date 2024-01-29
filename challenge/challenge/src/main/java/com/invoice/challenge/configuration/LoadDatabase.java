package com.invoice.challenge.configuration;

import java.sql.Time;
import java.util.Date;
import java.util.logging.Logger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.invoice.challenge.dao.InvoiceDao;
import com.invoice.challenge.model.Invoice;

@Configuration
class LoadDatabase {

	private final static Logger LOGGER = Logger.getLogger(LoadDatabase.class.getName());

	@Bean
	CommandLineRunner initDatabase(InvoiceDao dao) {

		return args -> {
			LOGGER.info("Preloading " + dao.save(
						new Invoice(Integer.valueOf(0), "cliente 1", "CF", 100F, null, null)
					)
			);
			LOGGER.info("Preloading " + dao.save(
						new Invoice(Integer.valueOf(0), "cliente 2", "CF", 105F, null, null)
					)
			);
		};
	}
}

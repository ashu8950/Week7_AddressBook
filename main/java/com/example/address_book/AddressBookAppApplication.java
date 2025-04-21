package com.example.address_book;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.classic.Logger;

@SpringBootApplication
public class AddressBookAppApplication {
	private static final Logger log = (Logger) LoggerFactory.getLogger(AddressBookAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AddressBookAppApplication.class, args);
		log.info("Server running");
	}

}

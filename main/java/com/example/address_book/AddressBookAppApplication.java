package com.example.address_book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class AddressBookAppApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AddressBookAppApplication.class, args);

        // Log at various levels
        log.info("Server is running...");
        log.debug("Debugging: Application context loaded");
        log.trace("Trace: Application context class = {}", context.getClass().getName());
        log.warn("Warning: This is a sample warning log");
        log.error("Error: Sample error log (nothing's wrong, just testing)");

        // Optional: application name
        String appName = context.getApplicationName();
        log.info("Application name: {}", appName.isEmpty() ? "(not set)" : appName);
    }
}

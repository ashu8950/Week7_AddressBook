package com.example.address_book.controller;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.address_book.dto.Response;
import com.example.address_book.model.Contact;
import com.example.address_book.service.AddressBookService;

@RestController
@RequestMapping("/address")
public class AddressBookController {

    @Autowired
    private AddressBookService service;

    // Add a new contact
    @PostMapping("/add")
    public ResponseEntity<Response> addContact(@RequestBody Contact contact) {
        try {
            Contact addedContact = service.addToAddressBook(contact);
            return ResponseEntity.ok(new Response("success", "Added successfully", addedContact, LocalTime.now()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new Response("error", e.getMessage(), null, LocalTime.now()));
        }
    }

    // Get contact details by ID
    @GetMapping("/getDetails/{id}")
    public ResponseEntity<Response> getDetails(@PathVariable int id) {
        try {
            Contact contact = service.getDetailById(id);
            return ResponseEntity.ok(new Response("success", "Fetched successfully", contact, LocalTime.now()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new Response("error", e.getMessage(), null, LocalTime.now()));
        }
    }

    // Get all contacts
    @GetMapping("/all")
    public ResponseEntity<Response> getAllContacts() {
        try {
            List<Contact> contacts = service.getAllContacts();
            return ResponseEntity.ok(new Response("success", "Retrieved all contacts successfully", contacts, LocalTime.now()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new Response("error", e.getMessage(), null, LocalTime.now()));
        }
    }

    // Delete contact by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteContact(@PathVariable int id) {
        try {
            service.deleteContactById(id);
            return ResponseEntity.ok(new Response("success", "Deleted successfully", null, LocalTime.now()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new Response("error", e.getMessage(), null, LocalTime.now()));
        }
    }

    // Update contact
    @PutMapping("/update/{id}")
    public ResponseEntity<Response> updateContact(@PathVariable int id, @RequestBody Contact contact) {
        try {
            service.updateContact(id, contact);
            return ResponseEntity.ok(new Response("success", "Updated successfully", contact, LocalTime.now()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new Response("error", e.getMessage(), null, LocalTime.now()));
        }
    }
}

package com.example.address_book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.address_book.model.Contact;
import com.example.address_book.repository.MyAddressRepository;

@Service
public class AddressBookService {
	@Autowired
	private MyAddressRepository rep;

	public Contact addToAddressBook(Contact contact) {
		// TODO Auto-generated method stub
		return rep.save(contact);
	}

	public Contact getDetailById(int id) {
		// TODO Auto-generated method stub
		return rep.findById(id).orElseThrow(()->new RuntimeException("Contact not found with this id"+id));
	}

	public List<Contact> getAllContacts() {
		// TODO Auto-generated method stub
		
		return rep.findAll();
	}

	public void deleteContactById(int id) {
		// TODO Auto-generated method stub
		rep.findById(id).orElseThrow(()->new RuntimeException("detail with this "+id+" does not exist"));
		rep.deleteById(id);
		
	}

	public void updateContact(int id, Contact contact) {
	    Contact existingContact = rep.findById(id)
	            .orElseThrow(() -> new RuntimeException("Contact with ID " + id + " not found"));

	    // Update fields
	    existingContact.setName(contact.getName());
	    existingContact.setEmail(contact.getEmail());
	    existingContact.setPhone(contact.getPhone());
	    existingContact.setAddress(contact.getAddress());

	    // Save updated contact
	    rep.save(existingContact);
	}


	
}

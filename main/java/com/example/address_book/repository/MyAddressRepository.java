package com.example.address_book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.address_book.model.Contact;

public interface MyAddressRepository extends JpaRepository<Contact,Integer> {

}

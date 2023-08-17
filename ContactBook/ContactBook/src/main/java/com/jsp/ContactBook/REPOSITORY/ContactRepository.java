package com.jsp.ContactBook.REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.ContactBook.DTO.Contact;

public interface ContactRepository extends JpaRepository<Contact,Integer>
{
	
}

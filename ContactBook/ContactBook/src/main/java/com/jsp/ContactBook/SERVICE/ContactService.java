package com.jsp.ContactBook.SERVICE;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.ContactBook.DTO.Contact;
import com.jsp.ContactBook.REPOSITORY.ContactRepository;

@Service  // @Repository any one we can take
public class ContactService 
{
	@Autowired
	ContactRepository repository;
	
	
	//----------------------  to save / insert contact into DB	-----------------------------
	public Contact addContact(Contact con)
	{
		return repository.save(con);
	}
	
	
	
	
	//------------------------ To search for a contact in DB  --------------------------------
	
	public Contact searchContact(int id)
	{
		Optional <Contact> opt = repository.findById(id);
		
		if(opt.isPresent())
		{
			return opt.get();		
		}
		return null;
	}
	
	
	
	
	
	// ------------------------ To remove a data from database -------------------------------
	
	public int removeContact(int id)
	{
		Contact c = searchContact(id);
		
		if(c!=null)
		{
			repository.deleteById(id);
			return 1;
		}
		return 0;
		
	}
	
	
	
	
	
	// ------------------------- To get all contact from database --------------------------------
	
	public List<Contact> getAllContact()
	{
		return repository.findAll();
		
	}
	
	
	// ------------------------- To update the Contact name -------------------------------
	
	public Contact updateContact(String name, int id)
	{
		Contact c = searchContact(id);
		
		if(c!=null)
		{
			c.setName(name);
			repository.save(c);
			return c;
		}
		return null;
	}
	
	
}

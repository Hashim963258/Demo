package com.jsp.ContactBook.EXCEL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jsp.ContactBook.DTO.Contact;

@Service
public class ExcelService 
{
	public List<Contact> parseExcelFile(MultipartFile file) throws EncryptedDocumentException, IOException  // -->MultipartFile is a class to store the client uploaded file this accepts the file as input List<Contact> because it will have to send multiple contact details to DB
	{
		List<Contact> contacts = new ArrayList<Contact>();
		
		Workbook book = WorkbookFactory.create(file.getInputStream());  // reading the files and storing it to workbook (Workbook is an interface)
		
		Sheet sheet = book.getSheetAt(0);  			//fetching the data at the '0th' sheet and storing it in Sheet type  interface
		
		Iterator<Row> rowIterator =  sheet.iterator();  //Sheet interface have iterator() of row type
		
		while(rowIterator.hasNext())
		{
			Row row = rowIterator.next();          	//iterating and storing the objects into row
			
			//String id = row.getCell(0).getStringCellValue();
			String name = row.getCell(0).getStringCellValue();   	// fetching the individual data from the object
			String number = row.getCell(1).getStringCellValue();	// fetching the individual data from the object
			
			Contact con = new Contact();     //And storing it to the Contact type 
			//con.setId(id);
			con.setName(name);
			con.setPhone(number);
			
			contacts.add(con);
		}
		
		return contacts;
	}
}

package com.jsp.ContactBook;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ContactBookApplication {

	public static void main(String[] args) 
	{
		SpringApplication.run(ContactBookApplication.class, args);
	}
	 
	List<VendorExtension> vendorExtensions = new ArrayList<VendorExtension>();
	
	//to provide contact details for the project
	Contact contact = new Contact("HASHIM", "https://jspiders.com", "hashimbasha50@gmail.com");
	
	// to provide details of the project / Api
	ApiInfo apiInfo = new ApiInfo("CONTACT BOOK API", "It allows to upload contacts to DB from excel file, also save, update, delete, retrieve", "Spring Boot-3.0", "https://jspiders.com", contact, "Jspiders", "https://jspiders.com", vendorExtensions);
	
	@Bean
	public Docket getApi()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.jsp.ContactBook"))
				.build()
				.apiInfo(apiInfo);
	}

}

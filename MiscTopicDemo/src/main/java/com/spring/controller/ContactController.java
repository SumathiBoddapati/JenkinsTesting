package com.spring.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
	
	//Query Request Parameter Based On Api 
	
	@GetMapping(value="/api/contact/v1", produces=MediaType.APPLICATION_JSON_VALUE)//OLD API
	public Contact getContact() {
		return new Contact("Tom", 12345);
	}
	@GetMapping(value="/api/contact/v2", produces=MediaType.APPLICATION_JSON_VALUE)//NEW API
	public Contactv2 getContact2() {
		return new Contactv2("Tom", 12345);
	}
    //param API
	@GetMapping(value="/api/contact", produces=MediaType.APPLICATION_JSON_VALUE,params="version=v1")//OLD API
	public Contact getContactParamsv1() {
		return new Contact("Tom", 12345);
	}
	@GetMapping(value="/api/contact", produces=MediaType.APPLICATION_JSON_VALUE,params="version=v2")//NEW API
	public Contactv2 getContactParamsv2() {
		return new Contactv2("Tom", 12345);
	}
	//Header API
	@GetMapping(value="/api/contact", produces=MediaType.APPLICATION_JSON_VALUE,headers="version=v1")//OLD API
	public Contact getContactHeaderv1() {
		return new Contact("Tom", 12345);
	}
	
	@GetMapping(value="/api/contact", produces=MediaType.APPLICATION_JSON_VALUE,headers="version=v2")//NEW API
	public Contactv2 getContactHeaderv2() {
		return new Contactv2("Tom", 12345);
	}
	
	
	//Content Negotiation based API versioning
	@GetMapping(value="/api/contact", produces="application/contact.v1+json")//OLD API
	public Contact getContactContentNegov1() {
		return new Contact("Tom", 12345);
	}
	@GetMapping(value="/api/contact", produces="application/contact.v2+json")//NEW API
	public Contactv2 getContactContentNegov2() {
		return new Contactv2("Tom", 12345);
	}



}

class Contact{
	private String name;
	private int mobile;
	public Contact(String name, int mobile) {
		super();
		this.name = name;
		this.mobile = mobile;
	}
	
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Contact [name=" + name + ", mobile=" + mobile + "]";
	}
	
}

class Contactv2{
	private String name;
	private int mobileNo;
	public Contactv2(String name, int mobileNo) {
		super();
		this.name = name;
		this.mobileNo = mobileNo;
	}
	public Contactv2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}
	@Override
	public String toString() {
		return "Contactv2 [name=" + name + ", mobileNo=" + mobileNo + "]";
	}
	
	
}
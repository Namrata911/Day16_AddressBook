package com.AddressBook.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class AddressBook {
	
	@Id
	int id;
	String name;
	@OneToMany
	@JoinColumn(columnDefinition = "Id")
	List<Address> addresses;
}

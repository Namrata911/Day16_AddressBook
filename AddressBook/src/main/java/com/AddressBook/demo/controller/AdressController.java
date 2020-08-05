package com.AddressBook.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.AddressBook.demo.DTO.AddressDTO;
import com.AddressBook.demo.customAnnotations.ValuesAllowed;
import com.AddressBook.demo.model.Address;
import com.AddressBook.demo.service.AddressService;

@RestController
@RequestMapping("/addressbook")
@Validated
public class AdressController {
	@Autowired
	AddressService addressService; 
	
	@GetMapping("/")
	public List<Address> getAllAddresses(@RequestParam(defaultValue = "id",required = false)
	@ValuesAllowed( values = { "lastName", "zip" }, message = "Wrong request parameter, allowed values are ") String sortBy) {
		return addressService.getAllAddresses(sortBy);
	}
	
	@GetMapping("/{id}")
	public Optional<Address> getAddressbyId(@PathVariable int id) {
		return addressService.getAddressById(id);
	}
	
	@PostMapping("/")
	public ResponseEntity<Object> addAdress( @Valid @RequestBody  AddressDTO addressDTO) {
		
		addressService.addAddress(addressDTO);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public void updateAddress(@PathVariable int id, @RequestBody @Valid AddressDTO dto) {
		addressService.updateAddress(id, dto);
	}
	
	@DeleteMapping("/{id}")
	public String removeAddress(@PathVariable int id) {
		return "Hello";
	}
	
	

}

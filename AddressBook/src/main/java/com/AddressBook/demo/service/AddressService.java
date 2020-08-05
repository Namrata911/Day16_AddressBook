package com.AddressBook.demo.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.AddressBook.demo.DTO.AddressDTO;
import com.AddressBook.demo.model.Address;
import com.AddressBook.demo.repository.AddressRepo;

@Service
public class AddressService {
	
	@Autowired
	AddressRepo addressRepo;
	
	
	
	public List<Address> getAllAddresses(String sortBy) {
		List<Address> list = new LinkedList<Address>();
		addressRepo.findAll(Sort.by(sortBy).ascending().and(Sort.by("firstName"))).forEach(x->list.add(x));
		return list;
		
	}
	
	public void addAddress(AddressDTO addressDTO) {
		
		addressRepo.save(addressDTO.valueOf());
		
	}
	
	public Optional<Address> getAddressById(int id) {
		return addressRepo.findById(id);
	}
	
	public void updateAddress(int id, AddressDTO dto) {
		Optional<Address> address = addressRepo.findById(id);
		if(address.isPresent()) {
			Address newAddress = dto.valueOf();
			newAddress.setId(address.get().getId());
			addressRepo.save(newAddress);
		}
	}
	
	public void deletById(int id) {
		addressRepo.deleteById(id);
	}

}

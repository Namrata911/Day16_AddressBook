package com.AddressBook.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AddressBook.demo.model.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

}

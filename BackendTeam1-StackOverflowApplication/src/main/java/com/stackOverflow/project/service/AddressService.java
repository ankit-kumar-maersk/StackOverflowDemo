package com.stackOverflow.project.service;

import java.util.List;

import com.stackOverflow.project.model.Address;
import com.stackOverflow.project.repository.AddressRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    
    @Autowired
	private AddressRepository addressRepository;

    public Address getAddressByUserId(long userid) {

		return addressRepository.findById(userid).get();
	}

    public Address getAddressById(long addressId)
	{
		return addressRepository.findById(addressId).get();		
	}

    public Address createAddress(Address address)
	{
		return addressRepository.save(address);
	}

    public String deleteAddressById(long addressId)
	{
		addressRepository.deleteById(addressId);
		return "Address with ID: "+Long.toString(addressId)+"has been removed successfully";
	}

    public Address updateAddressDetails(Address address, long id) {

		Address currentAddress = addressRepository.findById(id).orElse(null);
		currentAddress.setStreet_address(address.getStreet_address());
        
		return addressRepository.save(currentAddress);
	}

}

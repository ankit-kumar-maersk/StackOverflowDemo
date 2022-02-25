package com.stackOverflow.project.controller;

import java.util.List;

import com.stackOverflow.project.model.Address;
import com.stackOverflow.project.service.AddressService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/stackusersaddress")  //http://localhost:8080/stackusers/methods
public class AddressController {
    
    @Autowired
	private AddressService addressService;


    @GetMapping("/getAddress/{id}")
	public Address getBadgeById(@PathVariable long id) {
		return addressService.getAddressById(id);
	}

    @PostMapping("/addAddress")
    public ResponseEntity<Address> addUser(@RequestBody Address address) {
        return new ResponseEntity<Address>(addressService.createAddress(address), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteAddress/{id}")
		public String DeleteUser(@PathVariable long id) {
			return addressService.deleteAddressById(id);
		}

        @PutMapping(value = "/updateAddress/{id}")
        public String updateEmployee(@PathVariable long id, @RequestBody Address address)
        {
            addressService.updateAddressDetails(address,id);
            return "Updated!";
        }
}

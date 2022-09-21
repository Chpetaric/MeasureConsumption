package org.studyeasy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.studyeasy.entity.Address;
import org.studyeasy.services.AddressService;

@RestController
@RequestMapping("/addresses")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@GetMapping
	public List<Address> getAddresses() {
		return addressService.getAddresses();
	}

	@GetMapping("/{id}")
	public Address getAddress(@PathVariable int id) {
		return addressService.getAddress(id);
	}

	@PostMapping
	public void addAddress(@RequestBody Address address) {
		addressService.addAddress(address);
	}

	@PutMapping("/{id}")
	public void updateAddress(@RequestBody Address address, @PathVariable int id) {
		Address addressDb = addressService.getAddress(id);
		addressDb.setCity(address.getCity());
		addressDb.setCountry(address.getCountry());
		addressDb.setStreet(address.getStreet());
		addressDb.setStreetNumber(address.getStreetNumber());
		addressService.updateAddress(addressDb);
	}

	@DeleteMapping("/{id}")
	public void deleteAddress(@PathVariable int id) {
		addressService.deleteAddress(id);
	}
}
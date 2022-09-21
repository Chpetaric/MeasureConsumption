package org.studyeasy.services;

import java.util.List;

import org.studyeasy.entity.Address;

public interface AddressService {
	
	public List<Address> getAddresses();
	
	public Address getAddress(int id);
	
	public void addAddress(Address listElement);
	
	public void updateAddress(Address address);
	
	public void deleteAddress(int id);

}

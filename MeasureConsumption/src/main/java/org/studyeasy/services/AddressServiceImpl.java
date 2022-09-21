package org.studyeasy.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.studyeasy.entity.Address;
import org.studyeasy.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository repo;

	@Override
	public List<Address> getAddresses() {
		List<Address> list = new ArrayList<>();
		for (Address address : repo.findAll()) {
			list.add(address);
		}
		return list;
	}

	@Override
	public Address getAddress(int id) {
		return repo.findById(id).get();
	}

	@Override
	public void addAddress(Address listElement) {
		repo.save(listElement);
	}

	@Override
	public void updateAddress(Address address) {
		repo.save(address);

	}

	@Override
	public void deleteAddress(int id) {
		repo.deleteById(id);

	}

}

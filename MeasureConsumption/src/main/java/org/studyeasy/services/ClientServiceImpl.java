package org.studyeasy.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.studyeasy.entity.Client;
import org.studyeasy.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository repo;

	@Override
	public List<Client> getClients(){
		List<Client> list=new ArrayList<>();
		for (Client client : repo.findAll()) {
			list.add(client);
		}
		return list;
	}
	
	@Override
	public Client getClient(int id) {
		return repo.findById((int) id).get();
	}
	
	@Override
	public void addClient(Client listElement) {
	repo.save(listElement);
	}
	
	@Override
	public void updateClient(Client client) {
		repo.save(client);
		
	}
	
	@Override
	public void deleteClient(int id) {
		repo.deleteById(id);
		
	}

	
}






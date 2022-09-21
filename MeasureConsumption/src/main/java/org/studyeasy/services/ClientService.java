package org.studyeasy.services;

import java.util.List;

import org.studyeasy.entity.Client;

public interface ClientService {

	public List<Client> getClients();
	
	public Client getClient(int id);
	
	public void addClient(Client listElement);
	
	public void updateClient(Client client);
	
	public void deleteClient(int id);
	
}

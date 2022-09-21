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
import org.studyeasy.entity.Client;
import org.studyeasy.services.AddressService;
import org.studyeasy.services.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@Autowired
	private AddressService addressService;

	@GetMapping
	public List<Client> getClients() {
		return clientService.getClients();
	}

	@GetMapping("/{id}")
	public Client getClient(@PathVariable int id) {
		return clientService.getClient(id);
	}

	@PostMapping
	public void addClient(@RequestBody Client client) {
		addressService.addAddress(client.getAddress());
		clientService.addClient(client);
	}

	@PutMapping("/{id}")
	public void updateClient(@RequestBody Client client, @PathVariable int id) {
		Client clientDb = clientService.getClient(id);
		clientDb.setFirstName(client.getFirstName());
		clientDb.setLastName(client.getLastName());
		clientDb.setAddress(client.getAddress());
		clientDb.setMeters(client.getMeters());
		clientService.updateClient(clientDb);
	}

	@DeleteMapping("/{id}")
	public void deleteClient(@PathVariable int id) {
		clientService.deleteClient(id);
	}

}

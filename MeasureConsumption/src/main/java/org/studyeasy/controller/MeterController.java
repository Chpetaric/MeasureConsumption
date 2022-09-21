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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.studyeasy.entity.Client;
import org.studyeasy.entity.Meter;
import org.studyeasy.services.ClientService;
import org.studyeasy.services.MeterService;

@RestController
@RequestMapping("/meters")
public class MeterController {

	@Autowired
	private MeterService meterService;
	
	@Autowired
	private ClientService clientService;
	
	
	@GetMapping("/{idClient}/{year}/{month}")
	public String getMeter(@PathVariable int idClient, @PathVariable int year, @PathVariable int month) {
		return meterService.getMeasureOfYearOfMonth(idClient, year, month);	
		}
	
	@GetMapping("/{idClient}/{year}")
	public String getMeter(@PathVariable int idClient, @PathVariable int year) {
		return meterService.getMeasureOfYear(idClient, year);
	}
	
	@GetMapping("/{idClient}/{year}/all")
	public String getMeterAllMonths(@PathVariable int idClient, @PathVariable int year) {
		return meterService.getMeasureOfYearAllMonths(idClient, year);
	}
	
	@GetMapping
	public List<Meter> getMeters() {
		return meterService.getMeters();
	}

	/*@RequestMapping("/meters/{idClient}/{year}")
	public List<Meter> getMeterYearMonth(@PathParam("idClient") int idClient, @PathParam("year") int year) {
		return meterService.getMeterYearMonth(idClient, year);
	}*/
	
	@GetMapping("/{id}")
	public Meter getMeter(@PathVariable int id) {
		return meterService.getMeter(id);
	}

	@PostMapping
	public void addMeter(@RequestBody Meter meter, @RequestParam int clientId) {
		Client client = clientService.getClient(clientId);
		if(client==null) {
			throw new IllegalArgumentException("Client doesn't exist");
		}
		meter.setClient(client);
		meterService.addMeter(meter);
	}

	@PutMapping("/{id}")
	public void updateMeter(@RequestBody Meter meter, @PathVariable int id) {
		Meter meterDb = meterService.getMeter(id);
		meterDb.setClient(meter.getClient());
		meterDb.setDateOfMeasure(meter.getDateOfMeasure());
		meterDb.setConsumption(meter.getConsumption());
		meterService.updateMeter(meter);
	}

	@DeleteMapping("/{id}")
	public void deleteMeter(@PathVariable int id) {
		meterService.deleteMeter(id);
	}


	
}

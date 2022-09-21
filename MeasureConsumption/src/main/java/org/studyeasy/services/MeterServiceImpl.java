package org.studyeasy.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.studyeasy.entity.Meter;
import org.studyeasy.repository.MeterRepository;

@Service
public class MeterServiceImpl implements MeterService {


	@Autowired
	private MeterRepository meterRepo;
	
	public int consumptionOfYear;
	public int consumptionOfMonth;
	public List<String> measures = new ArrayList<String>();
	public Integer[] measureForTest;

	@Override
	public List<Meter> getMeters() {
		List<Meter> list = new ArrayList<>();
		for (Meter meter : meterRepo.findAll()) {
			list.add(meter);
		}
		return list;
	}

	@Override
	public Meter getMeter(int id) {
		return meterRepo.findById((int) id).get();
	}

	@Override
	public void addMeter(Meter meter) {
		meterRepo.save(meter);
	}

	@Override
	public void updateMeter(Meter meter) {
		meterRepo.save(meter);

	}

	@Override
	public void deleteMeter(int id) {
		meterRepo.deleteById(id);

	}

	@Override
	public String getMeasureOfYear(int clientId, int year) {
		List<Meter> meters = meterRepo.findByClientIdAndDateOfMeasureBetween(clientId, LocalDate.of(year, 1, 1),
				LocalDate.of(year, 12, 31));
		consumptionOfYear = 0;

		for (Meter meter : meters) {
			consumptionOfYear += meter.getConsumption();
		}

		return "Year = " + year + " total = " + consumptionOfYear;
	}

	@Override
	public String getMeasureOfYearOfMonth(int clientId, int year, int month) {
		List<Meter> meters = meterRepo.findByClientIdAndDateOfMeasureBetween(clientId, LocalDate.of(year, month, 1),
				LocalDate.of(year, month, 31));
		consumptionOfMonth = 0;
		// String nameMonth = "null";

		for (Meter meter : meters) {
			consumptionOfMonth += meter.getConsumption();
		}

		String nameMonth = "null";

		switch (month) {
		case 1:
			nameMonth = "January";
			break;
		case 2:
			nameMonth = "February";
			break;
		case 3:
			nameMonth = "March";
			break;
		case 4:
			nameMonth = "April";
			break;
		case 5:
			nameMonth = "May";
			break;
		case 6:
			nameMonth = "June";
			break;
		case 7:
			nameMonth = "July";
			break;
		case 8:
			nameMonth = "August";
			break;
		case 9:
			nameMonth = "September";
			break;
		case 10:
			nameMonth = "October";
			break;
		case 11:
			nameMonth = "November";
			break;
		case 12:
			nameMonth = "December";
			break;

		default:
		}

		return "Year = " + year + " " + nameMonth + " = " + consumptionOfMonth;
	}

	@Override
	public String getMeasureOfYearAllMonths(int clientId, int year) {
		List<Meter> meters = meterRepo.findByClientIdAndDateOfMeasureBetween(clientId, LocalDate.of(year, 1, 1),
				LocalDate.of(year, 12, 31));
		List<Integer> measureList = new ArrayList<>();
		
		for (Meter meter : meters) {
			measures.add(meter.getDateOfMeasure().getMonth().toString() + " = " + meter.getConsumption());
			
			measureList.add(meter.getConsumption());

		}
		
		measureForTest = new Integer[measureList.size()];
		for (int j = 0; j < measureList.size()-1; j++) {
			measureForTest[j]=measureList.get(j);
			System.out.println(measureForTest[j]);
		}

		return "Year = " + year + measures;
	}

}
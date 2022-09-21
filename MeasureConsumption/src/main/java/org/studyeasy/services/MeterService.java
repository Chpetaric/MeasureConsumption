package org.studyeasy.services;

import java.util.List;

import org.studyeasy.entity.Meter;

public interface MeterService {

	public List<Meter> getMeters();
	
	public Meter getMeter(int id);
	
	public void addMeter(Meter meter);
	
	public void updateMeter(Meter meter);
	
	public void deleteMeter(int id);
	
	public String getMeasureOfYear(int clientId, int year);
	
	public String getMeasureOfYearOfMonth(int clientId, int year, int month);
	
	public String getMeasureOfYearAllMonths(int clientId, int year);
}

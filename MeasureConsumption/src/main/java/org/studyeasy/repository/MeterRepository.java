package org.studyeasy.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.studyeasy.entity.Meter;


@Repository
public interface MeterRepository extends JpaRepository<Meter, Integer> {

	public List<Meter> findByClientIdAndDateOfMeasureBetween(int clientId, LocalDate startDate, LocalDate endDate);

	//public Meter findByClientIdAndDateOfMeasureMonthBetween(int clientId, LocalDate startDate, LocalDate endDate);
	
}
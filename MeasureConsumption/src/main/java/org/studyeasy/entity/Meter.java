package org.studyeasy.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="meter")
@Table(name = "meter")
public class Meter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_meter")
	private int id;
	
	@Column(name = "date_of_measure")
	private LocalDate dateOfMeasure;

	@Column(name = "consumption")
	private int consumption;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name="id_client", referencedColumnName = "id_client")
	private Client client;
	
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDateOfMeasure() {
		return dateOfMeasure;
	}

	public void setDateOfMeasure(LocalDate dateOfMeasure) {
		this.dateOfMeasure = dateOfMeasure;
	}

	public int getConsumption() {
		return consumption;
	}

	public void setConsumption(int consumption) {
		this.consumption = consumption;
	}
	
	
	
	
	 
}

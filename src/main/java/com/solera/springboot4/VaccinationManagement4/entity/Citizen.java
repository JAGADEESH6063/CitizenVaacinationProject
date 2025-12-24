package com.solera.springboot4.VaccinationManagement4.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="CitizenVMS")
@Table(name="CitizenVMS")
public class Citizen
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="ID")
	private int id;
	
	@Column(name="AADHARNUMBER",insertable=false, updatable=false)
	private String aadharNumber;
	
	@Column(name="FIRSTNAME")
	private String firstName;
	
	@Column(name="LASTNAME")
	private String lastName;
	
	@Column(name="VACCINENAME")
	private String vaccineName;
	
	@Column(name="VACCINATIONSTATUS")
	private String vaccinationStatus;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="AADHARNUMBER")
	private DoseInfo doseInfo;
	
	
	public Citizen() {
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAadharNumber() {
		return aadharNumber;
	}


	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getVaccineName() {
		return vaccineName;
	}


	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}


	public DoseInfo getDoseInfo() {
		return doseInfo;
	}


	public void setDoseInfo(DoseInfo doseInfo) {
		this.doseInfo = doseInfo;
	}


	public String getVaccinationStatus() {
		return vaccinationStatus;
	}


	public void setVaccinationStatus(String vaccinationStatus) {
		this.vaccinationStatus = vaccinationStatus;
	}

	
}

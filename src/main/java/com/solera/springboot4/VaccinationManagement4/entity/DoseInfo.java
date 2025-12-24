package com.solera.springboot4.VaccinationManagement4.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="citizendoseinfo")
@Table(name="citizendoseinfo")
public class DoseInfo 
{

	@Id
	@Column(name="AADHARID")
	private String aadharId;
	
	@Column(name = "DOSECOUNT")
	private int  doseCount;
	
	
	@Column(name="DOSE1DATE")
	private Date dose1Date;
	
	@Column(name="DOSE1STATUS")
	private String dose1Status;
	
	
	@Column(name="DOSE2DATE")
	private Date dose2Date;
	
	@Column(name="DOSE2STATUS")
	private String dose2Status;
	
	@Column(name="BOOSTERDATE")
	private Date boosterDate;
	
	@Column(name="BOOSTERSTATUS")
	private String boosterStatus;

	
	public DoseInfo() {
	}

	public String getAadharId() {
		return aadharId;
	}

	public void setAadharId(String aadharId) {
		this.aadharId = aadharId;
	}

	public String getDose1Status() {
		return dose1Status;
	}

	public void setDose1Status(String dose1Status) {
		this.dose1Status = dose1Status;
	}

	public Date getDose1Date() {
		return dose1Date;
	}

	public void setDose1Date(Date dose1Date) {
		this.dose1Date = dose1Date;
	}

	public String getDose2Status() {
		return dose2Status;
	}

	public void setDose2Status(String dose2Status) {
		this.dose2Status = dose2Status;
	}

	public Date getDose2Date() {
		return dose2Date;
	}

	public void setDose2Date(Date dose2Date) {
		this.dose2Date = dose2Date;
	}

	public Date getBoosterDate() {
		return boosterDate;
	}

	public void setBoosterDate(Date boosterDate) {
		this.boosterDate = boosterDate;
	}

	public String getBoosterStatus() {
		return boosterStatus;
	}

	public void setBoosterStatus(String boosterStatus) {
		this.boosterStatus = boosterStatus;
	}
	
	public int getDoseCount() {
		return doseCount;
	}

	public void setDoseCount(int doseCount) {
		this.doseCount = doseCount;
	}
	
}


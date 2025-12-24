package com.solera.springboot4.VaccinationManagement4.dao;

import java.util.List;

import com.solera.springboot4.VaccinationManagement4.entity.Citizen;
import com.solera.springboot4.VaccinationManagement4.entity.Report;

public interface CitizenDAO 
{
	
	public List<Citizen> getAll();

	public void newCitizen(Citizen theCitizen);
	
	public Citizen findOne(int id);
	
	public void editCitizen(Citizen theCitizen);
	
	public List<Citizen> displayListOfCitizensVaccineName(String name);

	public List<Report> countWiseReport();
	
	public List<Citizen> getPartlyOrFullyVaccinatedCitizen();

	public void deleteById(Citizen citizen);
	

}

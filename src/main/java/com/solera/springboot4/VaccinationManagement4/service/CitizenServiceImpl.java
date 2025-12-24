package com.solera.springboot4.VaccinationManagement4.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solera.springboot4.VaccinationManagement4.dao.CitizenDAO;
import com.solera.springboot4.VaccinationManagement4.entity.Citizen;
import com.solera.springboot4.VaccinationManagement4.entity.Report;

@Service
public class CitizenServiceImpl implements CitizenService
{

	private CitizenDAO citizenDAO;
	
	
	@Autowired
	public CitizenServiceImpl(CitizenDAO citizenDAO)
	{
		this.citizenDAO = citizenDAO;
	}



	@Override
	@Transactional
	public List<Citizen> getAll()
	{
		return citizenDAO.getAll();
	}


	@Override
	@Transactional
	public void newCitizen(Citizen theCitizen) {
		// TODO Auto-generated method stub
		citizenDAO.newCitizen(theCitizen);
		
	}
	
	@Override
	@Transactional
	public Citizen findOne(int id) 
	{
		// TODO Auto-generated method stub
		return citizenDAO.findOne(id);
	}

	@Override
	@Transactional
	public void editCitizen(Citizen theCitizen)
	{
		citizenDAO.editCitizen(theCitizen);
	}

	@Override
	@Transactional
	public List<Citizen> displayListOfCitizensVaccineName(String name) 
	{
		// TODO Auto-generated method stub
		return citizenDAO.displayListOfCitizensVaccineName(name);
	}
	
	@Override
	public List<Report> countWiseReport()
	{
		// TODO Auto-generated method stub
		return citizenDAO.countWiseReport();
	}
	
	@Override
	public List<Citizen> getPartlyOrFullyVaccinatedCitizen() 
	{
		// TODO Auto-generated method stub
		return citizenDAO.getPartlyOrFullyVaccinatedCitizen();
	}



	@Override
	@Transactional
	public void deleteById(Citizen citizen) 
	{
		// TODO Auto-generated method stub
		citizenDAO.deleteById(citizen);
	}

}

package com.solera.springboot4.VaccinationManagement4.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.solera.springboot4.VaccinationManagement4.entity.Citizen;
import com.solera.springboot4.VaccinationManagement4.entity.Report;

@Repository
public class CitizenDAOImpl implements CitizenDAO 
{

	private EntityManager entityManager;
	
	public CitizenDAOImpl(EntityManager entityManager) 
	{
		this.entityManager = entityManager;
	}

	
	
	
	@Override
	public List<Citizen> getAll() 
	{
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Citizen> theQuery = currentSession.createQuery("from CitizenVMS",Citizen.class);
		List<Citizen> citizens = theQuery.getResultList();
		
		return citizens;
	}

	//Adding new citizen
	@Override
	public void newCitizen(Citizen theCitizen) 
	{
		Session currentSession = entityManager.unwrap(Session.class);
		theCitizen.setVaccineName(theCitizen.getVaccineName().toLowerCase());
		if(theCitizen.getDoseInfo().getDose1Date()==null )
			throw new RuntimeException("Dose 1 date cannot be null");
		
		if(theCitizen.getDoseInfo().getDoseCount()>3 || theCitizen.getDoseInfo().getDoseCount()<0 )
			throw new RuntimeException("Dose count cannot be less than 0 or greater than 3");
		
		if(theCitizen.getDoseInfo().getDoseCount()==1)
		{
			theCitizen.setVaccinationStatus("PV");
			theCitizen.getDoseInfo().setDose1Status("done");
		}
		else if(theCitizen.getDoseInfo().getDoseCount()==2)
		{
			theCitizen.setVaccinationStatus("FV");
			theCitizen.getDoseInfo().setDose2Status("done");
		}
		else if(theCitizen.getDoseInfo().getDoseCount()==3)
		{
			theCitizen.setVaccinationStatus("BV");
			theCitizen.getDoseInfo().setBoosterStatus("done");
		}	
		
		currentSession.saveOrUpdate(theCitizen);
	}

	@Override
	public Citizen findOne(int id) 
	{
		Session currentSession = entityManager.unwrap(Session.class);
		Citizen theCitizen = currentSession.get(Citizen.class, id);
		return theCitizen;
	}
	
	public long findTimeDifference(Date d1, Date d2)
	{
		
		long time = d2.getTime()-d1.getTime();
		
		long days_difference = (time / (1000*60*60*24)); 
		
		return days_difference;
	}
	
	@Override
	public void editCitizen(Citizen theCitizen) 
	{
		long time = findTimeDifference(theCitizen.getDoseInfo().getDose1Date(), theCitizen.getDoseInfo().getDose2Date());
		
		if(time<=120)
		{
			throw new RuntimeException("Dose 1 and 2 has to be gapped by atleast 120 Days");
		}
		
		theCitizen.setVaccinationStatus("FV");
		theCitizen.getDoseInfo().setDose2Status("Done");
		theCitizen.getDoseInfo().setDoseCount(2);
		
		if(theCitizen.getDoseInfo().getBoosterDate() != null)
		{
			if(findTimeDifference(theCitizen.getDoseInfo().getDose2Date(), theCitizen.getDoseInfo().getBoosterDate()) <=270)
			throw new RuntimeException("Dose 2 and Booster has to be gapped by atleast 270 Days");
			
			else
			{
				theCitizen.setVaccinationStatus("BV");
				theCitizen.getDoseInfo().setBoosterStatus("Done");
				theCitizen.getDoseInfo().setDoseCount(3);
				Session currentSession = entityManager.unwrap(Session.class);
				currentSession.saveOrUpdate(theCitizen);
			}
		}
		
		else
			theCitizen.getDoseInfo().setBoosterStatus("Not Completed");
		
		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.saveOrUpdate(theCitizen);	
	}
	
	@Override
	public List<Citizen> displayListOfCitizensVaccineName(String name)
	{
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Citizen> theQuery = currentSession.createQuery("from CitizenVMS where VACCINENAME=:thename",Citizen.class);
		
		theQuery.setParameter("thename",name);
		
		List<Citizen> citizens = theQuery.getResultList();
		
		return citizens;
	}
	
	@Override
	public List<Report> countWiseReport()
	{
		Report covishieldCount = new Report("Covishield",0);
		Report covaxinCount = new Report("Covaxin",0);
		
		List<Citizen> list = getAll();
		
		for(Citizen c : list)
		{
			if(c.getVaccineName().equals("covishield"))
			{
				covishieldCount.setCount(covishieldCount.getCount()+1);
			}
			else
			{
				covaxinCount.setCount(covaxinCount.getCount()+1);
			}
		}
		
		List<Report> reports = new ArrayList<>();
		reports.add(covishieldCount);
		reports.add(covaxinCount);
		
		return reports;
	}
	
	@Override
	public List<Citizen> getPartlyOrFullyVaccinatedCitizen() 
	{
		List<Citizen> list = getAll();
		
		List<Citizen> citizens = new ArrayList<>(); 
		for(Citizen c : list)
		{
			if(c.getDoseInfo().getDoseCount() > 0)
			{
				citizens.add(c);
			}
		}
		
		// TODO Auto-generated method stub
		
		return citizens;
	}




	@Override
	public void deleteById(Citizen citizen) 
	{
		// TODO Auto-generated method stub
		if(citizen.getDoseInfo().getDoseCount() == 3)
		{
			Session currentSession = entityManager.unwrap(Session.class);
			currentSession.delete(citizen);
		}
		else
			throw new RuntimeException("Citizen is not fully Vaccinated");
		
	}

}

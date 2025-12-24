package com.solera.springboot4.VaccinationManagement4.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solera.springboot4.VaccinationManagement4.Exception.CitizenNotFoundException;
import com.solera.springboot4.VaccinationManagement4.entity.Citizen;
import com.solera.springboot4.VaccinationManagement4.entity.Report;
import com.solera.springboot4.VaccinationManagement4.service.CitizenService;

@RestController
@RequestMapping("/api")
public class CitizenRestController
{
	private CitizenService citizenService;

	@Autowired
	public CitizenRestController(CitizenService citizenService)
	{
		this.citizenService = citizenService;
	}

	//Get details of all the citizens
	@GetMapping("/getAllCitizens")
	public List<Citizen> getAll()
	{
		return citizenService.getAll();
	}

	
	//Register a new citizen
	@PostMapping("/newcitizen")
	public Citizen newCitizen(@RequestBody Citizen theCitizen) 
	{
		citizenService.newCitizen(theCitizen);
		return theCitizen;
	}
	
	@GetMapping("/getcitizen/{id}")
	public Citizen getOne(@PathVariable int id) 
	{
		Citizen currentId = citizenService.findOne(id);
		
		if(currentId == null) 
		{
			throw new CitizenNotFoundException("Citizen not found with id-" +id);
		}
		
		//int i = currentId.getDoseInfo().getDoseCount();
		
		
		return currentId;
	}

	@PutMapping("/editcitizen")
	public Citizen editCitizen(@RequestBody Citizen citizen)
	{
		citizenService.editCitizen(citizen);
		return citizen;
	}
	
	@GetMapping("/vaccinename/{vaccineName}")
	public List<Citizen> displayListOfCitizensVaccineName(@PathVariable String vaccineName)
	{
		vaccineName = vaccineName.toLowerCase();
		return citizenService.displayListOfCitizensVaccineName(vaccineName);
	}
	
	@GetMapping("/getcount")
	public List<Report> countWiseReport()
	{
		return citizenService.countWiseReport();
	}
	
	@GetMapping("/getvaccinated")
	public List<Citizen> getPartlyOrFullyVaccinatedCitizen()
	{
		return citizenService.getPartlyOrFullyVaccinatedCitizen();
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public Citizen deleteById(@PathVariable int id)
	{
		Citizen citizen = getOne(id);
		citizenService.deleteById(citizen);
		return citizen;		
	}
	
	
}

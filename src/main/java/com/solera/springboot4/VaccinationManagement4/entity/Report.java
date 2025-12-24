package com.solera.springboot4.VaccinationManagement4.entity;

public class Report
{

	private String vaccinename;
	private long count;
	public Report(String vaccinename, long count) 
	{
		this.vaccinename = vaccinename;
		this.count = count;
	}
	public Report()
	{
		// TODO Auto-generated constructor stub
	}
	public String getVaccinename() 
	{
		return vaccinename;
	}
	public void setVaccinename(String vaccinename) 
	{
		this.vaccinename = vaccinename;
	}
	public long getCount()
	{
		return count;
	}
	public void setCount(long count) 
	{
		this.count = count;
	}
	
	
}

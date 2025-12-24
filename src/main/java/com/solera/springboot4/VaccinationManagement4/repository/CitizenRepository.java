package com.solera.springboot4.VaccinationManagement4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solera.springboot4.VaccinationManagement4.entity.Citizen;

public interface CitizenRepository extends JpaRepository<Citizen, Integer>
{

}

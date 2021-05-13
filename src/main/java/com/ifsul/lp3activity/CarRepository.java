package com.ifsul.lp3activity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer>  {
	
	 List<Car> findByUserId(Integer id);
	 List<Car> findByCarLicensePlate(String carLicensePlate);

}

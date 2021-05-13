package com.ifsul.lp3activity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cars")
public class Car {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
		
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column(name="car_license_plate", length=7)
	private String carLicensePlate;
	
	@Column(name="color", length=45)
	private String color;
	
	@Column(name="model")
	private String model;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getCarLicensePlate() {
		return carLicensePlate;
	}

	public void setCarLicensePlate(String carLicensePlate) {
		this.carLicensePlate = carLicensePlate;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
    @Override
    public String toString() {
    	return String.format("%s - %s - %s", getModel(), getCarLicensePlate(), getColor());
    }
	
}

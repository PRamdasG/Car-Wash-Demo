package com.carwash.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "car")
public class Car {

	private int id;
	private String carCompany;
	private String carModel;
	private String ownerName;
	private String carNumber;

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCarCompany() {
		return carCompany;
	}

	public void setCarCompany(String carCompany) {
		this.carCompany = carCompany;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", carCompany=" + carCompany + ", carModel=" + carModel + "]";
	}

	public Car(int id, String carCompany, String carModel, String ownerName, String carNumber) {
		super();
		this.id = id;
		this.carCompany = carCompany;
		this.carModel = carModel;
		this.ownerName = ownerName;
		this.carNumber = carNumber;
	}
	
	

}

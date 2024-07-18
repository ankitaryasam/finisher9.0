package com.app.beans;


public class Car {
	
	private String model;
	private String company;
	private Integer enginePower;
	private String tyre;
	private String regNo;
	private String fuelType;
	
	
	
	public Car() {
		System.out.println("Car.Car()");
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public void setEnginePower(Integer enginePower) {
		this.enginePower = enginePower;
	}
	public void setTyre(String tyre) {
		this.tyre = tyre;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	
	@Override
	public String toString() {
		return "Car [model=" + model + ", company=" + company + ", enginePower=" + enginePower + ", tyre=" + tyre
				+ ", regNo=" + regNo + ", fuelType=" + fuelType + "]";
	}
	
	

}

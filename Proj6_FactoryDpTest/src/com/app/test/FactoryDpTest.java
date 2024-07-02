package com.app.test;

import com.app.car.Car;
import com.app.factory.CarFactory;

public class FactoryDpTest {
	
	public static void main(String[] args) {
		
		
		//suv class object
		Car car = null;
		car = CarFactory.getCarInstance("honda");
		
		
		car.startCar();
	}

}

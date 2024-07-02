package com.app.factory;

import com.app.car.Car;
import com.app.car.LuxuryCar;
import com.app.car.LuxuryEngine;
import com.app.car.SedanCar;
import com.app.car.SedanEngine;
import com.app.car.SuvCar;
import com.app.car.SuvEngine;

public class CarFactory {
	
	//static factory method
	
	
	public static Car getCarInstance(String carType) {
		Car car = null;
		
		if(carType.equalsIgnoreCase("luxury")) {
			car = new LuxuryCar(new LuxuryEngine());
		}
		else if(carType.equalsIgnoreCase("sedan")) {
			car = new SedanCar(new SedanEngine());
		}
		else if(carType.equalsIgnoreCase("suv")) {
			car = new SuvCar(new SuvEngine());
		}
		else {
			throw new IllegalArgumentException("wrong car type passed...");
		}
		
		return car;
	}

}

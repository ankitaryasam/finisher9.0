package com.app.car;

public class SuvCar implements Car {
	
    private SuvEngine engine;
	
	public SuvCar(SuvEngine engine) {
		this.engine=engine;
	}

	@Override
	public void startCar() {
		  engine.startEngine();
		  System.out.println("suv car is started");

	}

	@Override
	public void startMusicSystem() {
		// TODO Auto-generated method stub
		System.out.println("suv car music system started");

	}

	@Override
	public void moveCar() {
		// TODO Auto-generated method stub 
		
		System.out.println("suv car is moving");

	}

}

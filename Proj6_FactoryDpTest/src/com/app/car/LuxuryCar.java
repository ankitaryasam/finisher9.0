package com.app.car;

public class LuxuryCar implements Car {
	
	private LuxuryEngine engine;
	
	public LuxuryCar(LuxuryEngine engine) {
		this.engine=engine;
	}

	@Override
	public void startCar() {
	  engine.startEngine();
	  System.out.println("luxury car is started");
	}

	@Override
	public void startMusicSystem() {
		
		System.out.println("luxury car music system is started");
	}

	@Override
	public void moveCar() {
		System.out.println("your luxury car is moving");
		}

	}



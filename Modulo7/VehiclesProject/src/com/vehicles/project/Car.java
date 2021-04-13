package com.vehicles.project;

import java.util.List;

import personas.Titular;
import personas.Usuario;


public class Car extends Vehicle {

	public Car(String plate, String brand, String color, Titular titular, List<Usuario> conductores)throws Exception {
		super(plate, brand, color, titular,conductores);
		
	}	
	public void addWheels(List<Wheel> frontWheels, List<Wheel> backWheels) throws Exception {
		addTwoWheels(frontWheels);
		addTwoWheels(backWheels);
	}

	public void addTwoWheels(List<Wheel> wheels) throws Exception {
		if (wheels.size() != 2)
			throw new Exception();

		Wheel rightWheel = wheels.get(0);
		Wheel leftWheel = wheels.get(1);

		if (!rightWheel.equals(leftWheel))
			throw new Exception();

		this.wheels.add(leftWheel);
		this.wheels.add(rightWheel);
	}

	@Override
	public String toString() {
		return " plate: " + plate + ", brand: " + brand + ", color: " + color + ", wheels: " + wheels ;
	}

	

}

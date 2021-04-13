package com.vehicles.project;

import java.util.List;

import personas.Titular;
import personas.Usuario;

public class Bike extends Vehicle {

	public Bike(String plate, String brand, String color,Titular titular, List<Usuario> conductores) throws Exception {
		super(plate, brand, color,titular,conductores);
	}
	
	
	public void addWheels(Wheel frontWheels, Wheel backWheels ) throws Exception {			

		this.wheels.add(frontWheels);
		this.wheels.add(backWheels);
	}

	@Override
	public String toString() {
		return " plate=" + plate + ", brand=" + brand + ", color=" + color + ", wheels=" + wheels ;
	}		

}

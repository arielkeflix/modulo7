package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import personas.Titular;
import personas.Usuario;

public abstract class Vehicle {

	protected String plate;
	protected String brand;
	protected String color;
	protected Titular titular;
	protected List<Wheel> wheels = new ArrayList<Wheel>();
	protected List<Usuario> conductores = new ArrayList<>();
	protected String  tipoVehiculo;

	public Vehicle(String plate, String brand, String color, Titular titular, List<Usuario> conductores)throws Exception {
		
		Pattern pat = Pattern.compile("[0-9]{4}[a-zA-Z]{2,3}");
		 Matcher mat = pat.matcher(plate); 
		if (!mat.matches()) 
		throw new Exception("La matricula es erronea");
		
		this.plate   = plate;
		this.brand   = brand;
		this.color   = color;
		this.titular = titular;
		this.conductores = conductores;
	}

	public String getPlate() {
		return plate;
	}

	public String getBrand() {
		return brand;
	}

	public String getColor() {
		return color;
	}

	public Titular getTitular() {
		return titular;
	}

	public List<Usuario> getConductores() {
		return conductores;
	}

	public String getTipoVehiculo() {
		return this.getClass().getSimpleName();
	}
	
	
	

//	@Override
//	public String toString() {
//		return "plate: " + plate + ", brand: " + brand + ", color: " + color + ", wheels: " + wheels ;
//	}

	
   
	
	
}

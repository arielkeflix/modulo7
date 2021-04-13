package com.vehicles.project;

public class Wheel {
	private String brand;
	private double diameter;	
	final double MIN_DIAMETRO = 0.4;
	final double MAX_DIAMETRO = 4;

	public Wheel(String brand, double diameter) throws Exception {
		this.brand = brand;
		this.diameter = diameter;
		if(diameter< MIN_DIAMETRO  || diameter >MAX_DIAMETRO) throw new Exception
        ("Las ruedas deben tener un rango  entre : " + MIN_DIAMETRO  + " y "+ MAX_DIAMETRO    );
	}

	@Override
	public String toString() {
		return "brand=" + brand + ", diameter=" + diameter ;
	}
	
	
}

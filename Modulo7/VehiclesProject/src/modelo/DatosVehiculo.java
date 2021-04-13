package modelo;

import java.util.ArrayList;
import java.util.List;

import com.vehicles.project.Wheel;

import personas.Titular;
import personas.Usuario;

public  class DatosVehiculo {
	private    String plate;
	 private	String brand;
	 private	String color;
	 private	Wheel ruedaFront;
	 private	Wheel ruedaBack;
	 private    Titular titular;
	 private  List<Usuario> conductores = new ArrayList<>();
	    
	   
		public List<Usuario> getConductores() {
		return conductores;
	}
	public void setConductores(List<Usuario> conductores) {
		this.conductores = conductores;
	}
		public String getPlate() {
			return plate;
		}
		public void setPlate(String plate) {
			this.plate = plate;
		}
		public String getBrand() {
			return brand;
		}
		public void setBrand(String brandVehi) {
			this.brand = brandVehi;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public Wheel getRuedaFront() {
			return ruedaFront;
		}
		public void setRuedaFront(Wheel ruedaFront) {
			this.ruedaFront = ruedaFront;
		}
		public Wheel getRuedaBack() {
			return ruedaBack;
		}
		public void setRuedaBack(Wheel ruedaBack) {
			this.ruedaBack = ruedaBack;
		}
		public  Titular getTitular() {
			return titular;
		}
		public void setTitular( Titular titular) {
			this.titular = titular;
		}
		
		

}

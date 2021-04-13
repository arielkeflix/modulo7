package personas;

public class Titular extends Usuario{
	boolean seguro;
	boolean garage;
	
	public Titular(String nombre, String apellido, String fechaNacimiento, LicenciaConducir licenciaConducir,
			boolean seguro, boolean garage) {
		super(nombre, apellido, fechaNacimiento, licenciaConducir);
		this.seguro = seguro;
		this.garage = garage;
	}

	

	public boolean isSeguro() {
		return seguro;
	}

	public void setSeguro(boolean seguro) {
		this.seguro = seguro;
	}

	public boolean isGarage() {
		return garage;
	}

	public void setGarage(boolean garage) {
		this.garage = garage;
	}

	@Override
	public String toString() {
		return " seguro: " + seguro + ", garage:" + garage +   super.toString();
	}

	
	
	
}

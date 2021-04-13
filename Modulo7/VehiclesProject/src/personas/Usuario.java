package personas;


public  class Usuario {
	
	private String nombre;	
	private String apellido;	
	private String fechaNacimiento;
	LicenciaConducir licenciaConducir;
	
	
	public Usuario(String nombre, String apellido, String fechaNacimiento, LicenciaConducir licenciaConducir) {		
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.licenciaConducir = licenciaConducir;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	

	public LicenciaConducir getLicenciaConducir() {
		return licenciaConducir;
	}

	public void setLicenciaConducir(LicenciaConducir licenciaConducir) {
		this.licenciaConducir = licenciaConducir;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + ", apellido: " + apellido + ", fechaNacimiento=" + fechaNacimiento ;
	}
	

}

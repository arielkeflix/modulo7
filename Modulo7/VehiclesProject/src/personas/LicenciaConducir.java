package personas;

public class LicenciaConducir {
	
	private static int id=0;
	private String tipoLicencia;
	private String nombreCompleto;
	private String fechaCaducidad;		
	
	public LicenciaConducir( String tipoLicencia, String nombreCompleto, String fechaCaducidad) {	
		id++;
		this.tipoLicencia = tipoLicencia;
		this.nombreCompleto = nombreCompleto;
		this.fechaCaducidad = fechaCaducidad;
	}
	
	public int getId() {
		return id;
	}	
	

	public String getTipoLicencia() {
		return tipoLicencia;
	}

	public void setTipoLicencia(String tipoLicencia) {
		this.tipoLicencia = tipoLicencia;
	}
	

	public String getFechaCaducidad() {
		return fechaCaducidad;
	}

	

	@Override
	public String toString() {
		return  " ID Licencia: " + id + "TipoLicencia: " + tipoLicencia + ", nombreCompleto: " + nombreCompleto
				+ ", fechaCaducidad: " + fechaCaducidad ;
	}		

}

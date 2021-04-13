package modelo;

import java.util.ArrayList;
import java.util.List;

import com.vehicles.project.Vehicle;

import personas.Usuario;

public class Listas {

	private List<Usuario> usuarios = new ArrayList<>();
	
	private List<Vehicle> vehiculos = new ArrayList<>();
	 
	public void agregarUsuario (Usuario usuario) {
		usuarios.add(usuario);
	}
	public void agregarVehiculo (Vehicle vehiculo) {
		vehiculos.add(vehiculo);
	}
	public Usuario buscarUsuario(String nombre, String apellido)  {
		
		for (Usuario u:usuarios) {
			if (u.getNombre().equals(nombre)&& u.getApellido().equals(apellido) ) {
				return u;
			}
			else return  null;
		}
		return null;  
	}
}

package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import com.vehicles.project.Bike;
import com.vehicles.project.Camion;
import com.vehicles.project.Car;
import com.vehicles.project.Moto;
import com.vehicles.project.Vehicle;
import com.vehicles.project.Wheel;

import modelo.DatosVehiculo;

import personas.LicenciaConducir;
import personas.Titular;
import personas.Usuario;


public class Main {
	
    private static List<Usuario> usuarios = new ArrayList<>();	
	private  static List<Vehicle> vehiculos = new ArrayList<>();

	@SuppressWarnings("serial")
	static HashMap<Integer, String> hashVehiculos = new HashMap<Integer, String>() {
		{
			put(1, "coche");
			put(2, "bicicleta");
			put(3, "moto");
			put(4, "camion");
		}
	};

	public static void main(String[] args) throws Exception {
		
		Object[] options1 = { "Crear Usuario", "Crear vehiculo (Debe tener un usuario creado)", "Listar y terminar" }; // para cambiar el yes/no original del "showOptionDialog" "Crear Usuario", "Crear vehiculo"
		boolean continuar = true;
		
		while(continuar) {
			int opcion = JOptionPane.showOptionDialog(null, "MENU PRINCIPAL", "Seleccione",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options1, options1[0]);
			
			switch (opcion) {
			case 0:
				   crearUsuario();
				   break;
			case 1:
				   elegirVehiculo();
				   break;
			case 2:
				   MostrarListado listado = new MostrarListado( usuarios, vehiculos) ;
		    	   continuar = false;
				   break;
			case -1:
					continuar = false;
					break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcion);}	
		}			
	}	

	private static void elegirVehiculo() throws Exception {
		
		int opcion = Integer.parseInt( JOptionPane.showInputDialog("Elige un tipo de vehiculo ('1' para coche,  '2'  para bicicleta,"
						                              + " '3' para moto, 4 para camion "));
		switch (opcion) {
						case 1:
							crearCoche();
							break;
						case 2:
							crearBicicleta();
							break;
						case 3:
							crearMoto();
							break;
						case 4:
							crearCamion();
							break;
						default:
							throw new IllegalArgumentException("Unexpected value: " + opcion);
		}
	}

	private static Titular crearTitular(Usuario usuario) throws Exception {		

		// para titular
		boolean seguro;
		boolean garage;
		// uso local
		int opcion;
		Object[] options = { "SI", "NO!" };

		opcion = JOptionPane.showOptionDialog(null, "Tiene seguro", "Seleccione", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

		if (opcion == 0)
			seguro = true;
		else
			seguro = false;

		opcion = JOptionPane.showOptionDialog(null, "Tiene garage", "Seleccione", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

		if (opcion == 0)
			garage = true;
		else
			garage = false;

		return new Titular(usuario.getNombre(), usuario.getApellido(), usuario.getFechaNacimiento(),
				usuario.getLicenciaConducir(), seguro, garage);		
	}

	private static void crearUsuario() {

		// para persona
		String nombre;
		String apellido;
		String fechaNacimiento;
		// para licencia
		String tipoLicencia;
		String nombreCompleto;
		String fechaCaducidad;
		// uso local
		int opcion;

		// para persona
		nombre = JOptionPane.showInputDialog("   ingrese el nombre del usuario  ");
		apellido = JOptionPane.showInputDialog("   ingrese el apellido   ");
		fechaNacimiento = JOptionPane.showInputDialog("   ingrese fecha nacimiento   ");

		// para licencia
		nombreCompleto = nombre + " " + apellido;
		opcion = Integer.parseInt(JOptionPane.showInputDialog(
				" Ingrese tipo de licencia ('1' para coche,  '2'  para bicicleta," + " '3' para moto, 4 para camion "));
		tipoLicencia = hashVehiculos.get(opcion); // convierto el int en el String del la "hash"

		fechaCaducidad = JOptionPane.showInputDialog("  ingrese fecha de caducidad   ");

		LicenciaConducir licencia = new LicenciaConducir(tipoLicencia, nombreCompleto, fechaCaducidad);

		Usuario usuario = new Usuario(nombre, apellido, fechaNacimiento, licencia);
		
		usuarios.add(usuario);
	}

	private static void crearCamion() throws Exception {
		
		DatosVehiculo datos = crearVehiculo(hashVehiculos.get(4));
        
		if (datos != null) {
			
			try {
				List<Wheel> frontWheels = new ArrayList<Wheel>();
				List<Wheel> backWheels = new ArrayList<Wheel>();
				Camion camion = new Camion(datos.getPlate(), datos.getBrand(), datos.getColor(), datos.getTitular(),datos.getConductores());
		
				frontWheels.add(datos.getRuedaFront());
				frontWheels.add(datos.getRuedaFront());
				backWheels.add(datos.getRuedaBack());
				backWheels.add(datos.getRuedaBack());
		
				camion.addWheels(frontWheels, backWheels); // de acuerdo al la base del proyecto me obliga a mandar 2 List
	
				vehiculos.add(camion);
			} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"La matricula no coincide con el formato correcto (4 numero + 2 o 3 letras )no se pudo crear la moto",
	              "Importante!!", JOptionPane.ERROR_MESSAGE); 
	    }
		}		
	}

	private static void crearMoto() throws Exception {

		DatosVehiculo datos = crearVehiculo(hashVehiculos.get(3));
		if (datos != null) {
			
			try {
				Moto moto = new Moto(datos.getPlate(), datos.getBrand(), datos.getColor(), datos.getTitular(),datos.getConductores());	
				moto.addWheels(datos.getRuedaFront(), datos.getRuedaBack());
				vehiculos.add(moto);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"La matricula no coincide con el formato correcto (4 numero + 2 o 3 letras )no se pudo crear la moto",
		              "Importante!!", JOptionPane.ERROR_MESSAGE); 
		    }
		}	

	}

	private static void crearCoche() throws Exception {
		
		DatosVehiculo datos = crearVehiculo(hashVehiculos.get(1));
		if (datos != null) {
		   				
			try {
				Car coche = new Car(datos.getPlate(), datos.getBrand(), datos.getColor(), datos.getTitular(),datos.getConductores());			
			
				List<Wheel> frontWheels = new ArrayList<Wheel>();
				List<Wheel> backWheels = new ArrayList<Wheel>();
				frontWheels.add(datos.getRuedaFront());
				frontWheels.add(datos.getRuedaFront());
				backWheels.add(datos.getRuedaBack());
				backWheels.add(datos.getRuedaBack());
		
				coche.addWheels(frontWheels, backWheels); // de acuerdo al la base del proyecto me obliga a mandar 2 List
				
				vehiculos.add(coche);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"La matricula no coincide con el formato correcto (4 numero + 2 o 3 letras )no se pudo crear el coche",
			              "Importante!!", JOptionPane.ERROR_MESSAGE); 
			}
		}
	}

	private static void crearBicicleta() throws Exception {
		DatosVehiculo datos = crearVehiculo(hashVehiculos.get(2));
		if (datos != null) {
			try {
				Bike bicicleta = new Bike(datos.getPlate(), datos.getBrand(), datos.getColor(), datos.getTitular(),datos.getConductores());
		
				bicicleta.addWheels(datos.getRuedaFront(), datos.getRuedaBack());
		
				vehiculos.add(bicicleta);
			} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"La matricula no coincide con el formato correcto (4 numero + 2 o 3 letras )no se pudo crear la bicicleta",
		              "Importante!!", JOptionPane.ERROR_MESSAGE); 
		    }
		}
	}

	private static DatosVehiculo crearVehiculo(String tipoVehiculo) throws Exception {

		String brandWeel;
		double diameter;
		DatosVehiculo datosVehiculo;
		String nombre;
		String apellido;
		Usuario usuario;
		
		nombre = JOptionPane.showInputDialog(" Ingrese nombre de usuario ");
		apellido = JOptionPane.showInputDialog(" Ingrese apellido de usuario ");
		usuario = comprobarUsuario(nombre,apellido);   
		
		if (usuario==null) { 
			JOptionPane.showMessageDialog(null,"Al nombre y el apellido deben ser de un usuario registrado con anterioridad",
					                         "Importante!!", JOptionPane.ERROR_MESSAGE);  
			return null;
		}else if (usuario.getLicenciaConducir().getTipoLicencia() == tipoVehiculo) {	//compruebo coincidencia entre licencia y vehiculo elegido
			datosVehiculo = new DatosVehiculo();
			
			datosVehiculo.setTitular(crearTitular(usuario) );
			datosVehiculo.setPlate( JOptionPane.showInputDialog(" Ingrese la matricula (4 numero + 2 o 3 letras ) ") );
			datosVehiculo.setBrand( JOptionPane.showInputDialog("   Ingrese marca vehiculo   ") );
			datosVehiculo.setColor( JOptionPane.showInputDialog("   Ingrese color vehiculo   ") );
	
			brandWeel = JOptionPane.showInputDialog("   Ingrese marca ruedas delanteras   ");
			diameter = Integer
					.parseInt(JOptionPane.showInputDialog(" Ingrese diametro (entre 0,4 y 4 ) ruedas delanteras "));
			if (diameter < 0.4 || diameter > 4)
				throw new Exception("diametro de rueda erroneo");
			datosVehiculo.setRuedaFront( new Wheel(brandWeel, diameter) );
	
			brandWeel = JOptionPane.showInputDialog("   Ingrese marca ruedas traseras   ");
			diameter = Integer.parseInt(JOptionPane.showInputDialog(" Ingrese diametro (entre 0,4 y 4 ) ruedas traseras "));
			if (diameter < 0.4 || diameter > 4)
				throw new Exception("diametro de rueda erroneo");
			datosVehiculo.setRuedaBack( new Wheel(brandWeel, diameter) );	
			
			/**   conductores      *********/			
			datosVehiculo.setConductores(cargarConductores(tipoVehiculo));
			
			return datosVehiculo;			
	  }else {
		  JOptionPane.showMessageDialog(null,"El tipo de licencia del usuario registrado debe coincidir con el vehiculo elegido",
              "Importante!!", JOptionPane.ERROR_MESSAGE); 		  
		 return null;
	  }
  }

	private static List<Usuario> cargarConductores(String tipoVehiculo) {		
		
		List <Usuario> conductores = new ArrayList<Usuario>();
		Usuario usuario =null;		
		boolean continuar = true;				
		
		while (continuar) {
			String nombre =JOptionPane.showInputDialog(" Ingrese nombre de conductor ('fin' para finalizar)  ");
			if(nombre.equals("fin")) continuar = false;
		    else {
				   String apellido =JOptionPane.showInputDialog(" Ingrese apellido de conductor  ");
				   usuario = comprobarUsuario( nombre,  apellido);	
		    					
				if (usuario == null)  
				 JOptionPane.showMessageDialog(null,"Al nombre y el apellido deben ser de un usuario registrado con anterioridad",
		                "Importante!!", JOptionPane.ERROR_MESSAGE);
				 else if  (usuario.getLicenciaConducir().getTipoLicencia() == tipoVehiculo) conductores.add(usuario);
				 	  else  JOptionPane.showMessageDialog(null,"No coincide la licencia con el tipo de vehiculo","Importante!!", JOptionPane.ERROR_MESSAGE);
		    }	 		  
			if (conductores.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Tiene que haber al menos un conductor","Importante!!", JOptionPane.ERROR_MESSAGE);
					continuar =true;
			}		    			    
		}
		return conductores;
	}

	private static Usuario comprobarUsuario(String nombre, String apellido) {				
			
			for (Usuario u:usuarios) {
				if (u.getNombre().equals(nombre)&& u.getApellido().equals(apellido) ) {
					return u;
				}				
			}
			return null; 		
	}
}	



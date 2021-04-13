package view;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.vehicles.project.Vehicle;

import personas.Usuario;

public  class MostrarListado extends JFrame { // muestra el listado de los videos del usuario en una tabla, abajo hay un input
	
    private  List<Usuario> usuarios = new ArrayList<>();	
    private  List<Vehicle> vehiculos = new ArrayList<>();
    
	public MostrarListado(List<Usuario> usuarios, List<Vehicle> vehiculos) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.usuarios = usuarios;
		this.vehiculos = vehiculos;

		setBounds(0, 0, 600, 650);
		Font miFuente = new Font("Arial", Font.BOLD, 14);
		setLayout(null);
		String textoTablaInicio, textoTablaMedio = "", textoTablaFinal;
		
		textoTablaInicio = "<html><body> Listado de usuarios: "
		+ " <br>  <table > <head > <tr>  <th>Nombre</th> <th>Apellido</th>"
		+ " <th>FechaNacimiento</th> <th> Tipo de licencia</th> <th> Fecha caducidad</th>  </tr> </head> <body>  ";
		
		textoTablaFinal = " </body></table> </body> </html> ";
		
		for (Usuario u : usuarios) {				
			textoTablaMedio += " <tr> <td>" + u.getNombre() + "</td> <td>" + u.getApellido() + "</td><td>"
			+  u.getFechaNacimiento() + "</td><td>" + u.getLicenciaConducir().getTipoLicencia()  
			 + "</td><td>" + u.getLicenciaConducir().getFechaCaducidad()+ "</td>  " +  "</tr>";
		}
		
		JLabel listaUsuarios = new JLabel(textoTablaInicio + textoTablaMedio + textoTablaFinal);
		listaUsuarios.setFont(miFuente);
		listaUsuarios.setVerticalAlignment(JLabel.TOP);
		listaUsuarios.setForeground(Color.WHITE);
		listaUsuarios.setBounds(0, 0, 550, 300);
		listaUsuarios.setBackground(Color.BLACK);
		listaUsuarios.setOpaque(true);
		this.add(listaUsuarios);
		
		textoTablaMedio ="";
		textoTablaInicio = "<html><body> Listado de Vehiculos: "
				+ " <br>  <table > <head > <tr>  <th>Tipo de vehiculo</th> <th>Patente</th>"
				+ " <th>Matricula</th> <th> Color</th>   </tr> </head> <body>  ";
				
				textoTablaFinal = " </body></table> </body> </html> ";
				
				for (Vehicle v : vehiculos) {				
					textoTablaMedio += " <tr> <td>" +v.getTipoVehiculo() + "</td> <td>" + v.getPlate() + "</td> <td>" + v.getBrand() + "</td><td>"
					+  v.getColor() + "</td><td>" 
					+ "</td>  " +  "</tr> <tr><td> Conductores: </td> <td>";
					for (Usuario conductor:v.getConductores())
						textoTablaMedio += conductor.getNombre()+" "+conductor.getApellido()+", </td>";										
				}
				
				JLabel listaVehiculos = new JLabel(textoTablaInicio + textoTablaMedio + textoTablaFinal);
				listaVehiculos.setFont(miFuente);
				listaVehiculos.setVerticalAlignment(JLabel.TOP);
				listaVehiculos.setForeground(Color.BLACK);
				listaVehiculos.setBounds(0, 300, 550, 300);
				listaVehiculos.setBackground(Color.WHITE);
				listaVehiculos.setOpaque(true);
				this.add(listaVehiculos);
		
		
		
		
		setVisible(true);
  }
}

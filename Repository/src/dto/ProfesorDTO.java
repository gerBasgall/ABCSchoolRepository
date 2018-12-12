package dto;

import java.io.Serializable;
import java.util.Date;


public class ProfesorDTO extends UsuarioDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Float anticipacionReserva;
	private Float puntuacion;
	private String domicilioClases;
	
	public ProfesorDTO(int idUsuario,String dni, String nombre, String mail, String telefono, String domicilio, Date fechaNacimiento,String contra, String domicilioClases,Float anticipacion) {
		super(idUsuario,dni, nombre, mail, telefono, domicilio, fechaNacimiento, contra);
		this.anticipacionReserva=anticipacion;
		this.domicilioClases=domicilioClases;
	}
	public ProfesorDTO(String dni, String nombre, String mail, String telefono, String domicilio, Date fechaNacimiento,String contra, String domicilioClases,Float anticipacion) {
		super(dni, nombre, mail, telefono, domicilio, fechaNacimiento, contra);
		this.anticipacionReserva=anticipacion;
		this.domicilioClases=domicilioClases;
	}
	
	public String getDomicilioClases() {
		return domicilioClases;
	}
	public float getAnticipacionReserva() {
		return anticipacionReserva;
	}
	public float getPuntuacion() {
		return puntuacion;
	}
	
}

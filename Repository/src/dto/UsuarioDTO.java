package dto;

import java.util.Date;

public abstract class UsuarioDTO {
	protected Integer idUsuario;
	protected String dni;
	protected String nombre;
	protected String mail;
	protected String telefono;
	protected String domicilio;
	protected Date fechaNacimiento;
	protected String contra;
	
	public UsuarioDTO(int idUsuario,String dni, String nombre, String mail, String telefono, String domicilio, Date fechaNacimiento,String contra) {
		this.idUsuario=idUsuario;
		this.dni=dni;
		this.nombre=nombre;
		this.mail=mail;
		this.telefono=telefono;
		this.domicilio=domicilio;
		this.fechaNacimiento=fechaNacimiento;
		this.contra=contra;
	}
	
	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getMail() {
		return mail;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getContra() {
		return contra;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
}

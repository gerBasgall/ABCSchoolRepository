package dto;

import java.io.Serializable;

public class ClaseDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String materia;
	private Float horario;
	private String estado;
	private Integer idClase;
	private String profesor;
	
	public ClaseDTO(String materia, Float horario, String estado, Integer idClase, String profesor) {
		this.materia=materia;
		this.horario=horario;
		this.estado=estado;
		this.idClase=idClase;
		this.profesor=profesor;
	}
	
	public float getHorario() {
		return horario;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public int getIdClase() {
		return idClase;
	}
	
	public String getProfesor() {
		return profesor;
	}
	
	public String getMateria() {
		return materia;
	}

}

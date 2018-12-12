package dto;

import java.io.Serializable;

public class ResenaDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float puntuacion;
	private String comentario;

	public ResenaDTO(float puntuacion, String comentario) {
		this.puntuacion=puntuacion;
		this.comentario=comentario;
	}
	public float getPuntuacion() {
		return puntuacion;
	}

	public String getComentario() {
		return comentario;
	}

}

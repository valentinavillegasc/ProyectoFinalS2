package co.edu.unbosque.model.persistence;

import java.io.Serializable;

public class EntrenadorDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nombreEntrenador;
	private String correo;
	
	public String getNombreEntrenador() {
		return nombreEntrenador;
	}
	public void setNombreEntrenador(String nombreEntrenador) {
		this.nombreEntrenador = nombreEntrenador;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

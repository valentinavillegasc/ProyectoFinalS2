package co.edu.unbosque.model;

public class Entrenador {
	
	private String nombreEntrenador;
	private String correo;
	
	public Entrenador(String nombreEntrenador, String correo) {
		super();
		this.nombreEntrenador = nombreEntrenador;
		this.correo = correo;
	}

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
	
}

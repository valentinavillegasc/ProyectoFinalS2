package co.edu.unbosque.model;

public class Juego {
	
	private String nombreJuego;
	private int numeroParticipantes;
	
	public Juego(String nombreJuego, int numeroParticipantes) {
		super();
		this.nombreJuego = nombreJuego;
		this.numeroParticipantes = numeroParticipantes;
	}

	public String getNombreJuego() {
		return nombreJuego;
	}

	public void setNombreJuego(String nombreJuego) {
		this.nombreJuego = nombreJuego;
	}

	public int getNumeroParticipantes() {
		return numeroParticipantes;
	}

	public void setNumeroParticipantes(int numeroParticipantes) {
		this.numeroParticipantes = numeroParticipantes;
	}
	
}

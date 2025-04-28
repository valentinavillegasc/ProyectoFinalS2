package co.edu.unbosque.model;

import java.time.*;

public class JuegoRocket extends Juego{ // reglas
	
	private int tamanoEquipo;
	private Duration tiempoPartida;
	private boolean prorroga;

	public JuegoRocket(String nombreJuego, int numeroParticipantes) {
		super(nombreJuego, numeroParticipantes);
		tamanoEquipo = 3;
		tiempoPartida = Duration.ofMinutes(5);
		prorroga = true;
	}

	public int getTamanoEquipo() {
		return tamanoEquipo;
	}

	public void setTamanoEquipo(int tamanoEquipo) {
		this.tamanoEquipo = tamanoEquipo;
	}

	public Duration getTiempoPartida() {
		return tiempoPartida;
	}

	public void setTiempoPartida(Duration tiempoPartida) {
		this.tiempoPartida = tiempoPartida;
	}

	public boolean isProrroga() {
		return prorroga;
	}

	public void setProrroga(boolean prorroga) {
		this.prorroga = prorroga;
	}
	

}

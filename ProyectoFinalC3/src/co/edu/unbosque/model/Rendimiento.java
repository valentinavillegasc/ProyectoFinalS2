package co.edu.unbosque.model;

import java.util.Date;

public class Rendimiento {
	private Torneo torneo;
	private Date fecha;
	private int puntos;
	private int posicion;
	
	public Rendimiento(Torneo torneo, Date fecha, int puntos, int posicion) {
		super();
		this.torneo = torneo;
		this.fecha = fecha;
		this.puntos = puntos;
		this.posicion = posicion;
	}

	public Torneo getTorneo() {
		return torneo;
	}

	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	
	
}

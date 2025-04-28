package co.edu.unbosque.model;

import java.util.ArrayList;

public class Jugador {

	private String nombreJugador;
	private int puntosAcumulados;
	private ArrayList<Rendimiento> historialRendimiento;
	
	public Jugador(String nombreJugador) {
		super();
		this.nombreJugador = nombreJugador;
	}
	
	public String getNombreJugador() {
		return nombreJugador;
	}
	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}
	public int getPuntosAcumulados() {
		return puntosAcumulados;
	}
	public void setPuntosAcumulados(int puntosAcumulados) {
		this.puntosAcumulados = puntosAcumulados;
	}
	public ArrayList<Rendimiento> getHistorialRendimiento() {
		return historialRendimiento;
	}
	public void setHistorialRendimiento(ArrayList<Rendimiento> historialRendimiento) {
		this.historialRendimiento = historialRendimiento;
	}
	
	public void sumarPuntos(int puntosASumar) {
		puntosAcumulados += puntosASumar; 
	}
	
	public void eliminarRendimiento(Rendimiento rendimientoAEliminar) {
		historialRendimiento.remove(rendimientoAEliminar);
	}
	
	public void agregarRendimiento(Rendimiento rendimientoAAgregar) {
		historialRendimiento.add(rendimientoAAgregar);
	}
}

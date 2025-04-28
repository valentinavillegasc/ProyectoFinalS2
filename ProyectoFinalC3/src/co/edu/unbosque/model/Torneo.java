package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Date;

public class Torneo {

	private String nombreTorneo;
	private Date fecha;
	private Equipo[] equiposParticipantes;
	private ArrayList<Partida> partidas;
	private Equipo ganador;
	private Juego juego;
	
	public Torneo(String nombreTorneo, Date fecha, Equipo[] equiposParticipantes, ArrayList<Partida> partidas) {
		super();
		this.nombreTorneo = nombreTorneo;
		this.fecha = fecha;
		this.equiposParticipantes = equiposParticipantes;
		this.partidas = partidas;
	}
	
	public Torneo(String nombreTorneo) {
		super();
		this.nombreTorneo = nombreTorneo;
	}
	
	


	public String getNombreTorneo() {
		return nombreTorneo;
	}
	public void setNombreTorneo(String nombreTorneo) {
		this.nombreTorneo = nombreTorneo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Equipo[] getEquiposParticipantes() {
		return equiposParticipantes;
	}

	public void setEquiposParticipantes(Equipo[] equiposParticipantes) {
		this.equiposParticipantes = equiposParticipantes;
	}

	public ArrayList<Partida> getPartidas() {
		return partidas;
	}
	public void setPartidas(ArrayList<Partida> partidas) {
		this.partidas = partidas;
	}
	public Equipo getGanador() {
		return ganador;
	}
	public void setGanador(Equipo ganador) {
		this.ganador = ganador;
	}

	public Juego getJuego() {
		return juego;
	}

	public void setJuego(Juego juego) {
		this.juego = juego;
	}
	
	public void agregarPartida(Partida partida) {
		partidas.add(partida);
	}
}

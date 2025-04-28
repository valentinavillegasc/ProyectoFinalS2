package co.edu.unbosque.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;

public class Partida {
	
	private ArrayList<Equipo> equiposParticipantes;
	private Juego juego;
	private Torneo torneo;
	private Equipo ganador;
	private Date fecha;
	private HashMap<Equipo, Integer> posiciones;
	private int id;
	private String marcador;
	
	public Partida(Juego juego, Torneo torneo, Date fecha, int id) {
		super();
		this.juego = juego;
		this.torneo = torneo;
		this.fecha = fecha;
		this.id = id;
		equiposParticipantes = new ArrayList<Equipo>();
		posiciones = new HashMap<Equipo, Integer>();
		
	}

	public ArrayList<Equipo> getEquiposParticipantes() {
		return equiposParticipantes;
	}

	public void setEquiposParticipantes(ArrayList<Equipo> equiposParticipantes) {
		this.equiposParticipantes = equiposParticipantes;
	}

	public Juego getJuego() {
		return juego;
	}

	public void setJuego(Juego juego) {
		this.juego = juego;
	}

	public Torneo getTorneo() {
		return torneo;
	}

	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
	}

	public Equipo getGanador() {
		return ganador;
	}

	public void setGanador(Equipo ganador) {
		this.ganador = ganador;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public HashMap<Equipo, Integer> getPosiciones() {
		return posiciones;
	}

	public void setPosiciones(HashMap<Equipo, Integer> posiciones) {
		this.posiciones = posiciones;
	}
	
	public void eliminarEquipo(Equipo equipoAEliminar) {
		equiposParticipantes.remove(equipoAEliminar);
	}
	
	public void agregarEquipo(Equipo equipoAAgregar) {
		equiposParticipantes.add(equipoAAgregar);
	}
	
	public void modificarPosiciones (Equipo equipo, int posicion) {
		posiciones.put(equipo, posicion);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarcador() {
		return marcador;
	}

	public void setMarcador(String marcador) {
		this.marcador = marcador;
	}
	
}

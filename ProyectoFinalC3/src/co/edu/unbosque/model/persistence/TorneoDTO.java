package co.edu.unbosque.model.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import co.edu.unbosque.model.Equipo;
import co.edu.unbosque.model.Juego;
import co.edu.unbosque.model.Partida;

public class TorneoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombreTorneo;
    private Date fecha;
    private Equipo[] equiposParticipantes;
    private ArrayList<Partida> partidas;
    private Equipo ganador;
    private Juego juego;

    public TorneoDTO() {}

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

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}


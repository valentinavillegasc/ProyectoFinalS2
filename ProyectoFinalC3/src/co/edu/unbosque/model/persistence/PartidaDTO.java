package co.edu.unbosque.model.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import co.edu.unbosque.model.Equipo;
import co.edu.unbosque.model.Juego;
import co.edu.unbosque.model.Torneo;

public class PartidaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private ArrayList<Equipo> equiposParticipantes;
    private Juego juego;
    private Torneo torneo;
    private Equipo ganador;
    private Date fecha;
    private HashMap<Equipo, Integer> posiciones;
    private int id;
    private String marcador;

    public PartidaDTO() {
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

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}

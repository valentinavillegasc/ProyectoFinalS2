package co.edu.unbosque.model.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import co.edu.unbosque.model.Equipo;
import co.edu.unbosque.model.JuegoRocket;
import co.edu.unbosque.model.Partida;

public class TorneoRocketDTO extends TorneoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private JuegoRocket juego;
    private Equipo[] equiposCuartos;
    private Equipo[] equiposSemis;
    private Equipo[] equiposFinal;
    private HashMap<String, ArrayList<Partida>> partidasPorFase;
    private int id;

    public TorneoRocketDTO() {
        super();
    }

    public JuegoRocket getJuego() {
        return juego;
    }

    public void setJuego(JuegoRocket juego) {
        this.juego = juego;
    }

    public Equipo[] getEquiposCuartos() {
        return equiposCuartos;
    }

    public void setEquiposCuartos(Equipo[] equiposCuartos) {
        this.equiposCuartos = equiposCuartos;
    }

    public Equipo[] getEquiposSemis() {
        return equiposSemis;
    }

    public void setEquiposSemis(Equipo[] equiposSemis) {
        this.equiposSemis = equiposSemis;
    }

    public Equipo[] getEquiposFinal() {
        return equiposFinal;
    }

    public void setEquiposFinal(Equipo[] equiposFinal) {
        this.equiposFinal = equiposFinal;
    }

    public HashMap<String, ArrayList<Partida>> getPartidasPorFase() {
        return partidasPorFase;
    }

    public void setPartidasPorFase(HashMap<String, ArrayList<Partida>> partidasPorFase) {
        this.partidasPorFase = partidasPorFase;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}

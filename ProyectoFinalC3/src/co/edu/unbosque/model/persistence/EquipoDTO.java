package co.edu.unbosque.model.persistence;

import java.io.Serializable;
import java.util.ArrayList;

import co.edu.unbosque.model.Entrenador;
import co.edu.unbosque.model.Jugador;

public class EquipoDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String nombreEquipo;
    private ArrayList<Jugador> listaJugadores;
    private Entrenador entrenador;
    private String pais;
    private String ciudad;

    public EquipoDTO(String nombreEquipo, ArrayList<Jugador> listaJugadores, Entrenador entrenador, String pais, String ciudad) {
        this.nombreEquipo = nombreEquipo;
        this.listaJugadores = listaJugadores;
        this.entrenador = entrenador;
        this.pais = pais;
        this.ciudad = ciudad;
    }
    
    public EquipoDTO() {
        this.nombreEquipo = null;
        this.listaJugadores = null;
        this.entrenador = null;
        this.pais = null;
        this.ciudad = null;
    }

    public void eliminarJugador(Jugador jugadorAEliminar) {
        listaJugadores.remove(jugadorAEliminar);
    }

    public void agregarJugador(Jugador jugadorAAgregar) {
        listaJugadores.add(jugadorAAgregar);
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}

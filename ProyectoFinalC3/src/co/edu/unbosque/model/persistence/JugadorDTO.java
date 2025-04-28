package co.edu.unbosque.model.persistence;

import java.io.Serializable;
import java.util.ArrayList;

import co.edu.unbosque.model.Rendimiento;

public class JugadorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombreJugador;
    private int puntosAcumulados;
    private ArrayList<Rendimiento> historialRendimiento;

    public JugadorDTO() {
        historialRendimiento = new ArrayList<Rendimiento>();
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

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}

package co.edu.unbosque.model.persistence;

import java.io.Serializable;
import java.util.Date;

import co.edu.unbosque.model.Torneo;

public class RendimientoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Torneo torneo;
    private Date fecha;
    private int puntos;
    private int posicion;

    public RendimientoDTO() {}

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

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}

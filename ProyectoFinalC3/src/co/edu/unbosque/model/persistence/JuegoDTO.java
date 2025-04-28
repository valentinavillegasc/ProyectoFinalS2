package co.edu.unbosque.model.persistence;

import java.io.Serializable;

public class JuegoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombreJuego;
    private int numeroParticipantes;

    public JuegoDTO() {}

    public String getNombreJuego() {
        return nombreJuego;
    }

    public void setNombreJuego(String nombreJuego) {
        this.nombreJuego = nombreJuego;
    }

    public int getNumeroParticipantes() {
        return numeroParticipantes;
    }

    public void setNumeroParticipantes(int numeroParticipantes) {
        this.numeroParticipantes = numeroParticipantes;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}

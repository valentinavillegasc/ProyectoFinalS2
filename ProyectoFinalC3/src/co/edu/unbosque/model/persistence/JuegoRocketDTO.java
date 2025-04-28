package co.edu.unbosque.model.persistence;

import java.io.Serializable;
import java.time.Duration;

public class JuegoRocketDTO extends JuegoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private int tamanoEquipo;
    private Duration tiempoPartida;
    private boolean prorroga;

    public JuegoRocketDTO() {
        super();
    }

    public int getTamanoEquipo() {
        return tamanoEquipo;
    }

    public void setTamanoEquipo(int tamanoEquipo) {
        this.tamanoEquipo = tamanoEquipo;
    }

    public Duration getTiempoPartida() {
        return tiempoPartida;
    }

    public void setTiempoPartida(Duration tiempoPartida) {
        this.tiempoPartida = tiempoPartida;
    }

    public boolean isProrroga() {
        return prorroga;
    }

    public void setProrroga(boolean prorroga) {
        this.prorroga = prorroga;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}

package co.edu.unbosque.model.persistence;

import java.io.IOException;
import java.util.ArrayList;
import co.edu.unbosque.model.Jugador;

public class JugadorDAO implements InterfaceDAO<Jugador> {

    private Archivo archivo;
    private ArrayList<Jugador> datos;

    public JugadorDAO() {
        datos = new ArrayList<Jugador>();
        archivo = new ArchivoJugador("data/jugadores.dat");
    }

    public void actualizarBD() {
        datos = archivo.leerArchivo();
    }

    @Override
    public String getAll() {
        String rta = "";
        datos = archivo.leerArchivo();
        if (!datos.isEmpty()) {
            for (Jugador x : datos) {
                rta += x + "\n";
            }
        }
        return rta;
    }

    @Override
    public boolean add(Jugador x) {
        if (find(x) == null) {
            datos.add(x);
            archivo.escribirArchivo(datos);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Jugador x) {
        Jugador y = find(x);
        if (y != null) {
            try {
                datos.remove(y);
                archivo.getUbicacionArchivo().delete();
                archivo.getUbicacionArchivo().createNewFile();
                archivo.escribirArchivo(datos);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean update(Jugador x, Jugador y) {
        Jugador e = find(x);
        if (e != null) {
            try {
                datos.remove(e);
                e.setNombreJugador(y.getNombreJugador());
                e.setPuntosAcumulados(y.getPuntosAcumulados());
                e.setHistorialRendimiento(y.getHistorialRendimiento());
                datos.add(e);
                archivo.getUbicacionArchivo().delete();
                archivo.getUbicacionArchivo().createNewFile();
                archivo.escribirArchivo(datos);
                return true;
            } catch (IOException ex) {
                ex.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override
    public Jugador find(Jugador x) {
        Jugador encontrado = null;
        if (!datos.isEmpty()) {
            for (Jugador y : datos) {
                if (y.getNombreJugador().equals(x.getNombreJugador())) {
                    encontrado = y;
                }
            }
        }
        return encontrado;
    }
}

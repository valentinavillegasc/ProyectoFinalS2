package co.edu.unbosque.model.persistence;

import java.io.IOException;
import java.util.ArrayList;
import co.edu.unbosque.model.Torneo;

public class TorneoDAO implements InterfaceDAO<Torneo> {

    private Archivo archivo;
    private ArrayList<Torneo> datos;

    public TorneoDAO() {
        datos = new ArrayList<Torneo>();
        archivo = new ArchivoTorneo("data/torneos.dat");
    }

    public void actualizarBD() {
        datos = archivo.leerArchivo();
    }

    @Override
    public String getAll() {
        String rta = "";
        datos = archivo.leerArchivo();
        if (!datos.isEmpty()) {
            for (Torneo x : datos) {
                rta += x + "\n";
            }
        }
        return rta;
    }

    @Override
    public boolean add(Torneo x) {
        if (find(x) == null) {
            datos.add(x);
            archivo.escribirArchivo(datos);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Torneo x) {
        Torneo y = find(x);
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
    public boolean update(Torneo x, Torneo y) {
        Torneo e = find(x);
        if (e != null) {
            try {
                datos.remove(e);
                e.setNombreTorneo(y.getNombreTorneo());
                e.setFecha(y.getFecha());
                e.setEquiposParticipantes(y.getEquiposParticipantes());
                e.setPartidas(y.getPartidas());
                e.setGanador(y.getGanador());
                e.setJuego(y.getJuego());
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
    public Torneo find(Torneo x) {
        Torneo encontrado = null;
        if (!datos.isEmpty()) {
            for (Torneo y : datos) {
                if (y.getNombreTorneo().equals(x.getNombreTorneo())) {
                    encontrado = y;
                }
            }
        }
        return encontrado;
    }
}

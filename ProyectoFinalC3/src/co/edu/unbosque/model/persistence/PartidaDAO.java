package co.edu.unbosque.model.persistence;

import java.io.IOException;
import java.util.ArrayList;
import co.edu.unbosque.model.Partida;

public class PartidaDAO implements InterfaceDAO<Partida> {

    private Archivo archivo;
    private ArrayList<Partida> datos;

    public PartidaDAO() {
        datos = new ArrayList<Partida>();
        archivo = new ArchivoPartida("data/partidas.dat");
    }

    public void actualizarBD() {
        datos = archivo.leerArchivo();
    }

    @Override
    public String getAll() {
        String rta = "";
        datos = archivo.leerArchivo();
        if (!datos.isEmpty()) {
            for (Partida x : datos) {
                rta += x + "\n";
            }
        }
        return rta;
    }

    @Override
    public boolean add(Partida x) {
        if (find(x) == null) {
            datos.add(x);
            archivo.escribirArchivo(datos);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Partida x) {
        Partida y = find(x);
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
    public boolean update(Partida x, Partida y) {
        Partida e = find(x);
        if (e != null) {
            try {
                datos.remove(e);
                e.setJuego(y.getJuego());
                e.setTorneo(y.getTorneo());
                e.setFecha(y.getFecha());
                e.setGanador(y.getGanador());
                e.setEquiposParticipantes(y.getEquiposParticipantes());
                e.setPosiciones(y.getPosiciones());
                e.setMarcador(y.getMarcador());
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
    public Partida find(Partida x) {
        Partida encontrado = null;
        if (!datos.isEmpty()) {
            for (Partida y : datos) {
                if (y.getId() == x.getId()) { //  por ID 
                    encontrado = y;
                }
            }
        }
        return encontrado;
    }
}

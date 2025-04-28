package co.edu.unbosque.model.persistence;

import java.io.IOException;
import java.util.ArrayList;
import co.edu.unbosque.model.TorneoRocket;

public class TorneoRocketDAO implements InterfaceDAO<TorneoRocket> {

    private Archivo archivo;
    private ArrayList<TorneoRocket> datos;

    public TorneoRocketDAO() {
        datos = new ArrayList<TorneoRocket>();
        archivo = new ArchivoTorneoRocket("data/torneos_rocket.dat");
    }

    public void actualizarBD() {
        datos = archivo.leerArchivo();
    }

    @Override
    public String getAll() {
        String rta = "";
        datos = archivo.leerArchivo();
        if (!datos.isEmpty()) {
            for (TorneoRocket x : datos) {
                rta += x + "\n";
            }
        }
        return rta;
    }

    @Override
    public boolean add(TorneoRocket x) {
        if (find(x) == null) {
            datos.add(x);
            archivo.escribirArchivo(datos);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(TorneoRocket x) {
        TorneoRocket y = find(x);
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
    public boolean update(TorneoRocket x, TorneoRocket y) {
        TorneoRocket e = find(x);
        if (e != null) {
            try {
                datos.remove(e);
                e.setNombreTorneo(y.getNombreTorneo());
                e.setFecha(y.getFecha());
                e.setEquiposParticipantes(y.getEquiposParticipantes());
                e.setPartidas(y.getPartidas());
                e.setGanador(y.getGanador());
                e.setJuego(y.getJuego());
                e.setEquiposCuartos(y.getEquiposCuartos());
                e.setEquiposSemis(y.getEquiposSemis());
                e.setEquiposFinal(y.getEquiposFinal());
                e.setPartidasPorFase(y.getPartidasPorFase());
                e.setId(y.getId());
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
    public TorneoRocket find(TorneoRocket x) {
        TorneoRocket encontrado = null;
        if (!datos.isEmpty()) {
            for (TorneoRocket y : datos) {
                if (y.getNombreTorneo().equals(x.getNombreTorneo())) {
                    encontrado = y;
                }
            }
        }
        return encontrado;
    }
}

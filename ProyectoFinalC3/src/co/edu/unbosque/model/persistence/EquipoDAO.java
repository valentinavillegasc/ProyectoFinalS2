package co.edu.unbosque.model.persistence;

import java.io.IOException;
import java.util.ArrayList;
import co.edu.unbosque.model.Equipo;

public class EquipoDAO implements InterfaceDAO<Equipo> {

    private Archivo archivo;
    private ArrayList<Equipo> datos;

    public EquipoDAO() {
        datos = new ArrayList<Equipo>();
        archivo = new ArchivoEquipo("data/equipos.dat");
    }

    public void actualizarBD() {
        datos = archivo.leerArchivo();
    }

    @Override
    public String getAll() {
        String rta = "";
        datos = archivo.leerArchivo();
        if (!datos.isEmpty()) {
            for (Equipo x : datos) {
                rta += x + "\n";
            }
        }
        return rta;
    }

    @Override
    public boolean add(Equipo x) {
        if (find(x) == null) {
            datos.add(x);
            archivo.escribirArchivo(datos);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Equipo x) {
        Equipo y = find(x);
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
    public boolean update(Equipo x, Equipo y) {
        Equipo e = find(x);
        if (e != null) {
            try {
                datos.remove(e);
                e.setNombreEquipo(y.getNombreEquipo());
                e.setListaJugadores(y.getListaJugadores());
                e.setEntrenador(y.getEntrenador());
                e.setPais(y.getPais());
                e.setCiudad(y.getCiudad());
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
    public Equipo find(Equipo x) {
        Equipo encontrado = null;
        if (!datos.isEmpty()) {
            for (Equipo y : datos) {
                if (y.getNombreEquipo().equals(x.getNombreEquipo())) {
                    encontrado = y;
                }
            }
        }
        return encontrado;
    }
}

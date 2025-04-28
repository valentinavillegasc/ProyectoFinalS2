package co.edu.unbosque.model.persistence;

import java.io.IOException;
import java.util.ArrayList;
import co.edu.unbosque.model.Juego;

public class JuegoDAO implements InterfaceDAO<Juego> {

    private Archivo archivo;
    private ArrayList<Juego> datos;

    public JuegoDAO() {
        datos = new ArrayList<Juego>();
        archivo = new ArchivoJuego("data/juegos.dat");
    }

    public void actualizarBD() {
        datos = archivo.leerArchivo();
    }

    @Override
    public String getAll() {
        String rta = "";
        datos = archivo.leerArchivo();
        if (!datos.isEmpty()) {
            for (Juego x : datos) {
                rta += x + "\n";
            }
        }
        return rta;
    }

    @Override
    public boolean add(Juego x) {
        if (find(x) == null) {
            datos.add(x);
            archivo.escribirArchivo(datos);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Juego x) {
        Juego y = find(x);
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
    public boolean update(Juego x, Juego y) {
        Juego e = find(x);
        if (e != null) {
            try {
                datos.remove(e);
                e.setNombreJuego(y.getNombreJuego());
                e.setNumeroParticipantes(y.getNumeroParticipantes());
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
    public Juego find(Juego x) {
        Juego encontrado = null;
        if (!datos.isEmpty()) {
            for (Juego y : datos) {
                if (y.getNombreJuego().equals(x.getNombreJuego())) {
                    encontrado = y;
                }
            }
        }
        return encontrado;
    }
}

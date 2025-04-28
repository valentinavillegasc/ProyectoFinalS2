package co.edu.unbosque.model.persistence;

import java.io.IOException;
import java.util.ArrayList;
import co.edu.unbosque.model.JuegoRocket;

public class JuegoRocketDAO implements InterfaceDAO<JuegoRocket> {

    private Archivo archivo;
    private ArrayList<JuegoRocket> datos;

    public JuegoRocketDAO() {
        datos = new ArrayList<JuegoRocket>();
        archivo = new ArchivoJuegoRocket("data/juegos_rocket.dat");
    }

    public void actualizarBD() {
        datos = archivo.leerArchivo();
    }

    @Override
    public String getAll() {
        String rta = "";
        datos = archivo.leerArchivo();
        if (!datos.isEmpty()) {
            for (JuegoRocket x : datos) {
                rta += x + "\n";
            }
        }
        return rta;
    }

    @Override
    public boolean add(JuegoRocket x) {
        if (find(x) == null) {
            datos.add(x);
            archivo.escribirArchivo(datos);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(JuegoRocket x) {
        JuegoRocket y = find(x);
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
    public boolean update(JuegoRocket x, JuegoRocket y) {
        JuegoRocket e = find(x);
        if (e != null) {
            try {
                datos.remove(e);
                e.setNombreJuego(y.getNombreJuego());
                e.setNumeroParticipantes(y.getNumeroParticipantes());
                e.setTamanoEquipo(y.getTamanoEquipo());
                e.setTiempoPartida(y.getTiempoPartida());
                e.setProrroga(y.isProrroga());
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
    public JuegoRocket find(JuegoRocket x) {
        JuegoRocket encontrado = null;
        if (!datos.isEmpty()) {
            for (JuegoRocket y : datos) {
                if (y.getNombreJuego().equals(x.getNombreJuego())) {
                    encontrado = y;
                }
            }
        }
        return encontrado;
    }
}

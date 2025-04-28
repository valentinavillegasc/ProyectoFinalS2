package co.edu.unbosque.model.persistence;

import java.io.IOException;
import java.util.ArrayList;
import co.edu.unbosque.model.Rendimiento;

public class RendimientoDAO implements InterfaceDAO<Rendimiento> {

    private Archivo archivo;
    private ArrayList<Rendimiento> datos;

    public RendimientoDAO() {
        datos = new ArrayList<Rendimiento>();
        archivo = new ArchivoRendimiento("data/rendimientos.dat");
    }

    public void actualizarBD() {
        datos = archivo.leerArchivo();
    }

    @Override
    public String getAll() {
        String rta = "";
        datos = archivo.leerArchivo();
        if (!datos.isEmpty()) {
            for (Rendimiento x : datos) {
                rta += x + "\n";
            }
        }
        return rta;
    }

    @Override
    public boolean add(Rendimiento x) {
        if (find(x) == null) {
            datos.add(x);
            archivo.escribirArchivo(datos);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Rendimiento x) {
        Rendimiento y = find(x);
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
    public boolean update(Rendimiento x, Rendimiento y) {
        Rendimiento e = find(x);
        if (e != null) {
            try {
                datos.remove(e);
                e.setTorneo(y.getTorneo());
                e.setFecha(y.getFecha());
                e.setPuntos(y.getPuntos());
                e.setPosicion(y.getPosicion());
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
    public Rendimiento find(Rendimiento x) {
        Rendimiento encontrado = null;
        if (!datos.isEmpty()) {
            for (Rendimiento y : datos) {
                if (y.getFecha().equals(x.getFecha()) && y.getTorneo().equals(x.getTorneo())) {
                    encontrado = y;
                }
            }
        }
        return encontrado;
    }
}

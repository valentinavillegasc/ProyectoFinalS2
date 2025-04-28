package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.ArrayList;
import co.edu.unbosque.model.Rendimiento;

public class ArchivoRendimiento extends Archivo {

    public ArchivoRendimiento(String ruta) {
        super(ruta);
    }

    @SuppressWarnings("unchecked")
    @Override
    public ArrayList<Rendimiento> leerArchivo() {
        ArrayList<Rendimiento> lista = new ArrayList<>();
        if (getUbicacionArchivo().exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(getUbicacionArchivo()))) {
                lista = (ArrayList<Rendimiento>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }

    @Override
    public void escribirArchivo(ArrayList datos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(getUbicacionArchivo()))) {
            oos.writeObject(datos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.ArrayList;
import co.edu.unbosque.model.TorneoRocket;

public class ArchivoTorneoRocket extends Archivo {

    public ArchivoTorneoRocket(String ruta) {
        super(ruta);
    }

    @SuppressWarnings("unchecked")
    @Override
    public ArrayList<TorneoRocket> leerArchivo() {
        ArrayList<TorneoRocket> lista = new ArrayList<>();
        if (getUbicacionArchivo().exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(getUbicacionArchivo()))) {
                lista = (ArrayList<TorneoRocket>) ois.readObject();
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

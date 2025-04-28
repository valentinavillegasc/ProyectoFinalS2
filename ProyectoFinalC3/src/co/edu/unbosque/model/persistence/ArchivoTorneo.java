package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.ArrayList;
import co.edu.unbosque.model.Torneo;

public class ArchivoTorneo extends Archivo {

    public ArchivoTorneo(String ruta) {
        super(ruta);
    }

    @Override
    public ArrayList<Torneo> leerArchivo() {
        ArrayList<Torneo> lista = new ArrayList<>();
        if (getUbicacionArchivo().exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(getUbicacionArchivo()))) {
                lista = (ArrayList<Torneo>) ois.readObject();
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


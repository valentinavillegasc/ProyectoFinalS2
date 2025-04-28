package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.ArrayList;
import co.edu.unbosque.model.Juego;

public class ArchivoJuego extends Archivo {

    public ArchivoJuego(String ruta) {
        super(ruta);
    }

    @SuppressWarnings("unchecked")
    @Override
    public ArrayList<Juego> leerArchivo() {
        ArrayList<Juego> lista = new ArrayList<>();
        if (getUbicacionArchivo().exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(getUbicacionArchivo()))) {
                lista = (ArrayList<Juego>) ois.readObject();
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

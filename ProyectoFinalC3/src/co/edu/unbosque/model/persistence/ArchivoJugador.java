package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.ArrayList;
import co.edu.unbosque.model.Jugador;

public class ArchivoJugador extends Archivo {

    public ArchivoJugador(String ruta) {
        super(ruta);
    }

    @Override
    public ArrayList<Jugador> leerArchivo() {
        ArrayList<Jugador> lista = new ArrayList<>();
        if (getUbicacionArchivo().exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(getUbicacionArchivo()))) {
                lista = (ArrayList<Jugador>) ois.readObject();
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

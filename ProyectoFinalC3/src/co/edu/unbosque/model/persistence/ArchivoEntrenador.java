package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import co.edu.unbosque.model.Entrenador;

public class ArchivoEntrenador extends Archivo<Entrenador>{
	
	
	public ArchivoEntrenador(String ubicacion) {
		super(ubicacion);
	}
	
	@Override
	public ArrayList leerArchivo() {
		ArrayList<Entrenador> listaEntrenadores = null;
		
		if(ubicacionArchivo.length()!=0) {
			try {
				entrada = new ObjectInputStream(new FileInputStream(ubicacionArchivo));
				ArrayList<EntrenadorDTO> datos  = (ArrayList<EntrenadorDTO>) entrada.readObject();
				listaEntrenadores = MapHandler.convertirEntrenadorDTOtoEntrenador(datos);
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		return listaEntrenadores;
	}



	@Override
	public void escribirArchivo(ArrayList<Entrenador> datos) {
		try {
			salida = new ObjectOutputStream(new FileOutputStream(ubicacionArchivo));
			ArrayList<EntrenadorDTO> EntrenadoresDTO = MapHandler.convertirEntrenadorToEntrenadorDTO(datos);
			salida.writeObject(EntrenadoresDTO);
			salida.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}

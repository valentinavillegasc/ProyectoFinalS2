package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public abstract class Archivo<F> {

	protected ObjectInputStream entrada;
	protected ObjectOutputStream salida;
	protected File ubicacionArchivo;
	
	public Archivo(String ubicacion) {
		ubicacionArchivo = new File(ubicacion);
		if(!ubicacionArchivo.exists()) {
			try {
				ubicacionArchivo.createNewFile();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public abstract void escribirArchivo( ArrayList<F> datos);
	
	public abstract ArrayList<F> leerArchivo();

	public ObjectInputStream getEntrada() {
		return entrada;
	}

	public void setEntrada(ObjectInputStream entrada) {
		this.entrada = entrada;
	}

	public ObjectOutputStream getSalida() {
		return salida;
	}

	public void setSalida(ObjectOutputStream salida) {
		this.salida = salida;
	}

	public File getUbicacionArchivo() {
		return ubicacionArchivo;
	}

	public void setUbicacionArchivo(File ubicacionArchivo) {
		this.ubicacionArchivo = ubicacionArchivo;
	}
	
}

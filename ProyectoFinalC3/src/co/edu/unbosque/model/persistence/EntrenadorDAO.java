package co.edu.unbosque.model.persistence;

import java.io.IOException;
import java.util.ArrayList;

import co.edu.unbosque.model.Entrenador;

public class EntrenadorDAO implements InterfaceDAO<Entrenador> {

	private Archivo archivo;
	private ArrayList<Entrenador> datos;
	
	public EntrenadorDAO() {
		datos = new ArrayList<Entrenador>();
		archivo = new ArchivoEntrenador("data/entrenadores.dat");
	}

	public void actualizarBD() {
		datos = archivo.leerArchivo();
	}
	
	@Override
	public String getAll() {
		
		String rta = "";
		datos = archivo.leerArchivo();
		if(!datos.isEmpty()) {
			for(Entrenador x : datos) {
				rta += x + "\n";
			}
		}
		return rta;
	}

	@Override
	public boolean add(Entrenador x) {
		if(find(x) == null) {
			datos.add(x);
			archivo.escribirArchivo(datos);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Entrenador x) {
		
		Entrenador y = find(x);
		if(y != null) {
			try {
				datos.remove(y);
				archivo.getUbicacionArchivo().delete();
				archivo.getUbicacionArchivo().createNewFile();
				archivo.escribirArchivo(datos);
				return true;
			}catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean update(Entrenador x, Entrenador y) {
		Entrenador e = find(x);
		if(e != null) {
			try {
				datos.remove(e);
				e.setCorreo(y.getCorreo());
				e.setNombreEntrenador(y.getNombreEntrenador());
				datos.add(e);
				archivo.getUbicacionArchivo().delete();
				archivo.getUbicacionArchivo().createNewFile();
				archivo.escribirArchivo(datos);
				return true;
			}catch (IOException ex) {
				ex.printStackTrace();
				return false;
			}
		}
		return false;
	}

	@Override
	public Entrenador find(Entrenador x) {
		Entrenador encontrado = null;
		if(!datos.isEmpty()) {
			for(Entrenador y : datos) {
				if( y.getNombreEntrenador().equals(x.getNombreEntrenador())) {
					encontrado = y;
				}
			}
		}
		
		return encontrado;
	}

}

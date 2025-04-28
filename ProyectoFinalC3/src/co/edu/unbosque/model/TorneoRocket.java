package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class TorneoRocket extends Torneo{
	

	private JuegoRocket juego;
	private Equipo[] equiposCuartos;
	private Equipo[] equiposSemis;
	private Equipo[] equiposFinal;
	private HashMap<String, ArrayList<Partida>> partidasPorFase;
	private int id;
	
	public TorneoRocket(String nombreTorneo, Date fecha, Equipo[] equiposParticipantes,
			ArrayList<Partida> partidas) {
		super(nombreTorneo, fecha, equiposParticipantes, partidas);
		juego = new JuegoRocket("Rocket League", 16);
		setJuego(juego);
		equiposCuartos = new Equipo[8];
		equiposSemis = new Equipo[4];
		equiposFinal = new Equipo[2];
		partidasPorFase = new HashMap<String, ArrayList<Partida>>();
		id = 1;
	}
	
	public TorneoRocket(String nombreTorneo) {
		super(nombreTorneo);
		juego = new JuegoRocket("Rocket League", 16);
		setJuego(juego);
		equiposCuartos = new Equipo[8];
		equiposSemis = new Equipo[4];
		equiposFinal = new Equipo[2];
		partidasPorFase = new HashMap<String, ArrayList<Partida>>();
		setEquiposParticipantes(new Equipo[juego.getNumeroParticipantes()]);
		id = 1;
	}
	
	public void agregarEquipoFase(Equipo equipo,String fase) {
		
		switch(fase) {
		
		case "cuartos":
			for(Equipo equipo1: equiposCuartos) {
				if(equipo1==null) {
					equipo1=equipo;
					break;
				}
			}
			break;
			
		case "semis":
			for(Equipo equipo1: equiposSemis) {
				if(equipo1==null) {
					equipo1=equipo;
					break;
				}
			}
			break;
			
		case "final":
			for(Equipo equipo1: equiposFinal) {
				if(equipo1==null) {
					equipo1=equipo;
					break;
				}
			}
			break;
		}
		
	}


	public void organizarPartidos(String fase, Date fecha) {
		
		ArrayList<Equipo> equipos = new ArrayList<Equipo>();
		ArrayList<Partida> partidas = new ArrayList<Partida>();
		Random random = new Random();
		switch(fase) {

		case "octavos":
			for(int i=0; i<8;i++) {
				Equipo equipo1;
				Equipo equipo2;
				
				do {
					equipo1 = getEquiposParticipantes()[random.nextInt(15)];
				}while(verificarEquipo(equipos, equipo1));
				
				equipos.add(equipo1);
				
				do {
					equipo2 = getEquiposParticipantes()[random.nextInt(15)];
				}while(verificarEquipo(equipos, equipo2));
				
				equipos.add(equipo2);
				Partida partida = new Partida(juego, this, fecha, id);
				partida.agregarEquipo(equipo1);
				partida.agregarEquipo(equipo2);
				id++;
				agregarPartida(partida);
				partidas.add(partida);
			}
			partidasPorFase.put(fase, partidas);
			break;
		
		case "cuartos":
			for(int i=0; i<4;i++) {
				Equipo equipo1;
				Equipo equipo2;
				
				do {
					equipo1 = equiposCuartos[random.nextInt(7)];
				}while(verificarEquipo(equipos, equipo1));
				
				equipos.add(equipo1);
				
				do {
					equipo2 = equiposCuartos[random.nextInt(7)];
				}while(verificarEquipo(equipos, equipo2));
				
				equipos.add(equipo2);
				Partida partida = new Partida(juego, this, fecha, id);
				partida.agregarEquipo(equipo1);
				partida.agregarEquipo(equipo2);
				id++;
				agregarPartida(partida);
				partidas.add(partida);
			}
			partidasPorFase.put(fase, partidas);
			break;
			
		case "semis":
			
			for(int i=0; i<2;i++) {
				Equipo equipo1;
				Equipo equipo2;
				
				do {
					equipo1 = equiposSemis[random.nextInt(3)];
				}while(verificarEquipo(equipos, equipo1));
				
				equipos.add(equipo1);
				
				do {
					equipo2 = equiposSemis[random.nextInt(3)];
				}while(verificarEquipo(equipos, equipo2));
				
				equipos.add(equipo2);
				Partida partida = new Partida(juego, this, fecha, id);
				partida.agregarEquipo(equipo1);
				partida.agregarEquipo(equipo2);
				id++;
				agregarPartida(partida);
				partidas.add(partida);
			}
			partidasPorFase.put(fase, partidas);
			
			break;
			
		case "final":
			
			Partida partida = new Partida(juego, this, fecha, id);
			partida.agregarEquipo(equiposFinal[0]);
			partida.agregarEquipo(equiposFinal[1]);
			id++;
			agregarPartida(partida);
			partidas.add(partida);
			partidasPorFase.put(fase, partidas);
			
			break;
		}
	}
	
	public boolean verificarEquipo(ArrayList<Equipo> equipos, Equipo equipo) {
		
		for(Equipo equipoAVErificar:equipos) {
			if(equipoAVErificar.getNombreEquipo().equals(equipo.getNombreEquipo())) {
				return true;
			}
		}
		return false;
	}
	
	public void AgregarMarcador(int id, String marcador, Equipo equipoGanador) {
		
		for(Partida partida: getPartidas()) {
			if(partida.getId()==id) {
				partida.setMarcador(marcador);
				partida.setGanador(equipoGanador);
				break;
			}
		}
	}

	public JuegoRocket getJuego() {
		return juego;
	}

	public void setJuego(JuegoRocket juego) {
		this.juego = juego;
	}

	public Equipo[] getEquiposCuartos() {
		return equiposCuartos;
	}

	public void setEquiposCuartos(Equipo[] equiposCuartos) {
		this.equiposCuartos = equiposCuartos;
	}

	public Equipo[] getEquiposSemis() {
		return equiposSemis;
	}

	public void setEquiposSemis(Equipo[] equiposSemis) {
		this.equiposSemis = equiposSemis;
	}

	public Equipo[] getEquiposFinal() {
		return equiposFinal;
	}

	public void setEquiposFinal(Equipo[] equiposFinal) {
		this.equiposFinal = equiposFinal;
	}

	public HashMap<String, ArrayList<Partida>> getPartidasPorFase() {
		return partidasPorFase;
	}

	public void setPartidasPorFase(HashMap<String, ArrayList<Partida>> partidasPorFase) {
		this.partidasPorFase = partidasPorFase;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}

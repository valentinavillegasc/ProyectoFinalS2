package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Entrenador;
import co.edu.unbosque.model.Equipo;
import co.edu.unbosque.model.Juego;
import co.edu.unbosque.model.JuegoRocket;
import co.edu.unbosque.model.Jugador;
import co.edu.unbosque.model.Partida;
import co.edu.unbosque.model.Rendimiento;
import co.edu.unbosque.model.Torneo;
import co.edu.unbosque.model.TorneoRocket;

public class MapHandler {

	public static ArrayList<Entrenador> convertirEntrenadorDTOtoEntrenador(ArrayList<EntrenadorDTO> datos) {
		ArrayList<Entrenador> x = new ArrayList<Entrenador>();
        for (EntrenadorDTO mDTO : datos) { // Inicia un bucle for-each que recorre cada objeto MascotaDTO en la lista vDTO. En cada iteración, el objeto actual de la lista se almacena en la variable mDTO.
        	Entrenador aux = convertirEntrenadorDTOtoEntrenador(mDTO);
            x.add(aux);
        }
        return x;
	}

	private static Entrenador convertirEntrenadorDTOtoEntrenador(EntrenadorDTO mDTO) {
		Entrenador x = new Entrenador(mDTO.getNombreEntrenador(), mDTO.getCorreo());
		return x;
	}

	public static ArrayList<EntrenadorDTO> convertirEntrenadorToEntrenadorDTO(ArrayList<Entrenador> datos) {
		ArrayList<EntrenadorDTO> x = new ArrayList<EntrenadorDTO>();
        for (Entrenador mas : datos) {
        	EntrenadorDTO aux = convertirEntrenadortoEntrenadorDTO(mas);
            x.add(aux);
        }
        return x;
	}

	private static EntrenadorDTO convertirEntrenadortoEntrenadorDTO(Entrenador mas) {
		EntrenadorDTO x = new EntrenadorDTO();
		x.setNombreEntrenador(mas.getNombreEntrenador());
		x.setCorreo(mas.getCorreo());
		return x;
	}
	  
	//Equipo
	
	public static ArrayList<Equipo> convertirEquipoDTOtoEquipo(ArrayList<EquipoDTO> datos) {
        ArrayList<Equipo> x = new ArrayList<Equipo>();
        for (EquipoDTO mDTO : datos) {
            Equipo aux = convertirEquipoDTOtoEquipo(mDTO);
            x.add(aux);
        }
        return x;
    }

    private static Equipo convertirEquipoDTOtoEquipo(EquipoDTO mDTO) {
        Equipo x = new Equipo(mDTO.getNombreEquipo(), mDTO.getListaJugadores(), mDTO.getEntrenador(), mDTO.getPais(), mDTO.getCiudad());
        return x;
    }

    public static ArrayList<EquipoDTO> convertirEquipoToEquipoDTO(ArrayList<Equipo> datos) {
        ArrayList<EquipoDTO> x = new ArrayList<EquipoDTO>();
        for (Equipo mas : datos) {
            EquipoDTO aux = convertirEquipoToEquipoDTO(mas);
            x.add(aux);
        }
        return x;
    }

    private static EquipoDTO convertirEquipoToEquipoDTO(Equipo mas) {
        EquipoDTO x = new EquipoDTO();
        x.setNombreEquipo(mas.getNombreEquipo());
        x.setListaJugadores(mas.getListaJugadores());
        x.setEntrenador(mas.getEntrenador());
        x.setPais(mas.getPais());
        x.setCiudad(mas.getCiudad());
        return x;
    }
    
 // Metodos de Jugador
    public static ArrayList<Jugador> convertirJugadorDTOtoJugador(ArrayList<JugadorDTO> datos) {
        ArrayList<Jugador> x = new ArrayList<Jugador>();
        for (JugadorDTO mDTO : datos) {
            Jugador aux = convertirJugadorDTOtoJugador(mDTO);
            x.add(aux);
        }
        return x;
    }

    private static Jugador convertirJugadorDTOtoJugador(JugadorDTO mDTO) {
        Jugador x = new Jugador(mDTO.getNombreJugador());
        x.setPuntosAcumulados(mDTO.getPuntosAcumulados());
        x.setHistorialRendimiento(mDTO.getHistorialRendimiento());
        return x;
    }

    public static ArrayList<JugadorDTO> convertirJugadorToJugadorDTO(ArrayList<Jugador> datos) {
        ArrayList<JugadorDTO> x = new ArrayList<JugadorDTO>();
        for (Jugador mas : datos) {
            JugadorDTO aux = convertirJugadorToJugadorDTO(mas);
            x.add(aux);
        }
        return x;
    }

    private static JugadorDTO convertirJugadorToJugadorDTO(Jugador mas) {
        JugadorDTO x = new JugadorDTO();
        x.setNombreJugador(mas.getNombreJugador());
        x.setPuntosAcumulados(mas.getPuntosAcumulados());
        x.setHistorialRendimiento(mas.getHistorialRendimiento());
        return x;
    }
 //  para Partida
    public static ArrayList<Partida> convertirPartidaDTOtoPartida(ArrayList<PartidaDTO> datos) {
        ArrayList<Partida> x = new ArrayList<Partida>();
        for (PartidaDTO mDTO : datos) {
            Partida aux = convertirPartidaDTOtoPartida(mDTO);
            x.add(aux);
        }
        return x;
    }

    private static Partida convertirPartidaDTOtoPartida(PartidaDTO mDTO) {
        Partida x = new Partida(mDTO.getJuego(), mDTO.getTorneo(), mDTO.getFecha(), mDTO.getId());
        x.setEquiposParticipantes(mDTO.getEquiposParticipantes());
        x.setGanador(mDTO.getGanador());
        x.setPosiciones(mDTO.getPosiciones());
        x.setMarcador(mDTO.getMarcador());
        return x;
    }

    public static ArrayList<PartidaDTO> convertirPartidaToPartidaDTO(ArrayList<Partida> datos) {
        ArrayList<PartidaDTO> x = new ArrayList<PartidaDTO>();
        for (Partida mas : datos) {
            PartidaDTO aux = convertirPartidaToPartidaDTO(mas);
            x.add(aux);
        }
        return x;
    }

    private static PartidaDTO convertirPartidaToPartidaDTO(Partida mas) {
        PartidaDTO x = new PartidaDTO();
        x.setJuego(mas.getJuego());
        x.setTorneo(mas.getTorneo());
        x.setFecha(mas.getFecha());
        x.setId(mas.getId());
        x.setEquiposParticipantes(mas.getEquiposParticipantes());
        x.setGanador(mas.getGanador());
        x.setPosiciones(mas.getPosiciones());
        x.setMarcador(mas.getMarcador());
        return x;
    }

 // para Rendimiento
    public static ArrayList<Rendimiento> convertirRendimientoDTOtoRendimiento(ArrayList<RendimientoDTO> datos) {
        ArrayList<Rendimiento> x = new ArrayList<Rendimiento>();
        for (RendimientoDTO mDTO : datos) {
            Rendimiento aux = convertirRendimientoDTOtoRendimiento(mDTO);
            x.add(aux);
        }
        return x;
    }

    private static Rendimiento convertirRendimientoDTOtoRendimiento(RendimientoDTO mDTO) {
        Rendimiento x = new Rendimiento(mDTO.getTorneo(), mDTO.getFecha(), mDTO.getPuntos(), mDTO.getPosicion());
        return x;
    }

    public static ArrayList<RendimientoDTO> convertirRendimientoToRendimientoDTO(ArrayList<Rendimiento> datos) {
        ArrayList<RendimientoDTO> x = new ArrayList<RendimientoDTO>();
        for (Rendimiento mas : datos) {
            RendimientoDTO aux = convertirRendimientoToRendimientoDTO(mas);
            x.add(aux);
        }
        return x;
    }

    private static RendimientoDTO convertirRendimientoToRendimientoDTO(Rendimiento mas) {
        RendimientoDTO x = new RendimientoDTO();
        x.setTorneo(mas.getTorneo());
        x.setFecha(mas.getFecha());
        x.setPuntos(mas.getPuntos());
        x.setPosicion(mas.getPosicion());
        return x;
    }

 // Métodos para Torneo
    public static ArrayList<Torneo> convertirTorneoDTOtoTorneo(ArrayList<TorneoDTO> datos) {
        ArrayList<Torneo> x = new ArrayList<Torneo>();
        for (TorneoDTO mDTO : datos) {
            Torneo aux = convertirTorneoDTOtoTorneo(mDTO);
            x.add(aux);
        }
        return x;
    }

    private static Torneo convertirTorneoDTOtoTorneo(TorneoDTO mDTO) {
        Torneo x = new Torneo(mDTO.getNombreTorneo());
        x.setFecha(mDTO.getFecha());
        x.setEquiposParticipantes(mDTO.getEquiposParticipantes());
        x.setPartidas(mDTO.getPartidas());
        x.setGanador(mDTO.getGanador());
        x.setJuego(mDTO.getJuego());
        return x;
    }

    public static ArrayList<TorneoDTO> convertirTorneoToTorneoDTO(ArrayList<Torneo> datos) {
        ArrayList<TorneoDTO> x = new ArrayList<TorneoDTO>();
        for (Torneo mas : datos) {
            TorneoDTO aux = convertirTorneoToTorneoDTO(mas);
            x.add(aux);
        }
        return x;
    }

    private static TorneoDTO convertirTorneoToTorneoDTO(Torneo mas) {
        TorneoDTO x = new TorneoDTO();
        x.setNombreTorneo(mas.getNombreTorneo());
        x.setFecha(mas.getFecha());
        x.setEquiposParticipantes(mas.getEquiposParticipantes());
        x.setPartidas(mas.getPartidas());
        x.setGanador(mas.getGanador());
        x.setJuego(mas.getJuego());
        return x;
    }
    
 // Métodos para TorneoRocket
    public static ArrayList<TorneoRocket> convertirTorneoRocketDTOtoTorneoRocket(ArrayList<TorneoRocketDTO> datos) {
        ArrayList<TorneoRocket> x = new ArrayList<TorneoRocket>();
        for (TorneoRocketDTO mDTO : datos) {
            TorneoRocket aux = convertirTorneoRocketDTOtoTorneoRocket(mDTO);
            x.add(aux);
        }
        return x;
    }

    private static TorneoRocket convertirTorneoRocketDTOtoTorneoRocket(TorneoRocketDTO mDTO) {
        TorneoRocket x = new TorneoRocket(mDTO.getNombreTorneo());
        x.setFecha(mDTO.getFecha());
        x.setEquiposParticipantes(mDTO.getEquiposParticipantes());
        x.setPartidas(mDTO.getPartidas());
        x.setGanador(mDTO.getGanador());
        x.setJuego(mDTO.getJuego());
        x.setEquiposCuartos(mDTO.getEquiposCuartos());
        x.setEquiposSemis(mDTO.getEquiposSemis());
        x.setEquiposFinal(mDTO.getEquiposFinal());
        x.setPartidasPorFase(mDTO.getPartidasPorFase());
        x.setId(mDTO.getId());
        return x;
    }

    public static ArrayList<TorneoRocketDTO> convertirTorneoRocketToTorneoRocketDTO(ArrayList<TorneoRocket> datos) {
        ArrayList<TorneoRocketDTO> x = new ArrayList<TorneoRocketDTO>();
        for (TorneoRocket mas : datos) {
            TorneoRocketDTO aux = convertirTorneoRocketToTorneoRocketDTO(mas);
            x.add(aux);
        }
        return x;
    }

    private static TorneoRocketDTO convertirTorneoRocketToTorneoRocketDTO(TorneoRocket mas) {
        TorneoRocketDTO x = new TorneoRocketDTO();
        x.setNombreTorneo(mas.getNombreTorneo());
        x.setFecha(mas.getFecha());
        x.setEquiposParticipantes(mas.getEquiposParticipantes());
        x.setPartidas(mas.getPartidas());
        x.setGanador(mas.getGanador());
        x.setJuego(mas.getJuego());
        x.setEquiposCuartos(mas.getEquiposCuartos());
        x.setEquiposSemis(mas.getEquiposSemis());
        x.setEquiposFinal(mas.getEquiposFinal());
        x.setPartidasPorFase(mas.getPartidasPorFase());
        x.setId(mas.getId());
        return x;
    }
    
 // Métodos para Juego
    public static ArrayList<Juego> convertirJuegoDTOtoJuego(ArrayList<JuegoDTO> datos) {
        ArrayList<Juego> x = new ArrayList<Juego>();
        for (JuegoDTO mDTO : datos) {
            Juego aux = convertirJuegoDTOtoJuego(mDTO);
            x.add(aux);
        }
        return x;
    }

    private static Juego convertirJuegoDTOtoJuego(JuegoDTO mDTO) {
        Juego x = new Juego(mDTO.getNombreJuego(), mDTO.getNumeroParticipantes());
        return x;
    }

    public static ArrayList<JuegoDTO> convertirJuegoToJuegoDTO(ArrayList<Juego> datos) {
        ArrayList<JuegoDTO> x = new ArrayList<JuegoDTO>();
        for (Juego mas : datos) {
            JuegoDTO aux = convertirJuegoToJuegoDTO(mas);
            x.add(aux);
        }
        return x;
    }

    private static JuegoDTO convertirJuegoToJuegoDTO(Juego mas) {
        JuegoDTO x = new JuegoDTO();
        x.setNombreJuego(mas.getNombreJuego());
        x.setNumeroParticipantes(mas.getNumeroParticipantes());
        return x;
    }
 // Métodos para JuegoRocket
    public static ArrayList<JuegoRocket> convertirJuegoRocketDTOtoJuegoRocket(ArrayList<JuegoRocketDTO> datos) {
        ArrayList<JuegoRocket> x = new ArrayList<JuegoRocket>();
        for (JuegoRocketDTO mDTO : datos) {
            JuegoRocket aux = convertirJuegoRocketDTOtoJuegoRocket(mDTO);
            x.add(aux);
        }
        return x;
    }

    private static JuegoRocket convertirJuegoRocketDTOtoJuegoRocket(JuegoRocketDTO mDTO) {
        JuegoRocket x = new JuegoRocket(mDTO.getNombreJuego(), mDTO.getNumeroParticipantes());
        x.setTamanoEquipo(mDTO.getTamanoEquipo());
        x.setTiempoPartida(mDTO.getTiempoPartida());
        x.setProrroga(mDTO.isProrroga());
        return x;
    }

    public static ArrayList<JuegoRocketDTO> convertirJuegoRocketToJuegoRocketDTO(ArrayList<JuegoRocket> datos) {
        ArrayList<JuegoRocketDTO> x = new ArrayList<JuegoRocketDTO>();
        for (JuegoRocket mas : datos) {
            JuegoRocketDTO aux = convertirJuegoRocketToJuegoRocketDTO(mas);
            x.add(aux);
        }
        return x;
    }

    private static JuegoRocketDTO convertirJuegoRocketToJuegoRocketDTO(JuegoRocket mas) {
        JuegoRocketDTO x = new JuegoRocketDTO();
        x.setNombreJuego(mas.getNombreJuego());
        x.setNumeroParticipantes(mas.getNumeroParticipantes());
        x.setTamanoEquipo(mas.getTamanoEquipo());
        x.setTiempoPartida(mas.getTiempoPartida());
        x.setProrroga(mas.isProrroga());
        return x;
    }

    
}

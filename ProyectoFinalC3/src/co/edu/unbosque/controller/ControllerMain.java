package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.model.Entrenador;
import co.edu.unbosque.model.Equipo;
import co.edu.unbosque.model.Juego;
import co.edu.unbosque.model.JuegoRocket;
import co.edu.unbosque.model.Jugador;
import co.edu.unbosque.model.Partida;
import co.edu.unbosque.model.Rendimiento;
import co.edu.unbosque.model.Torneo;
import co.edu.unbosque.model.TorneoRocket;
import co.edu.unbosque.model.persistence.EntrenadorDAO;
import co.edu.unbosque.model.persistence.EquipoDTO;
import co.edu.unbosque.view.VentanaPrincipal;

public class ControllerMain implements ActionListener{

	private VentanaPrincipal vPrincipal;
	private Entrenador entrenador;
	private Equipo equipo;
	private Juego juego;
	private JuegoRocket jRocket;
	private Jugador jugador;
	private Partida partida;
	private Rendimiento rendimiento;
	private Torneo torneo;
	private TorneoRocket tRocket;
	private String juegoActual;
	private EntrenadorDAO entrenadorDAO;
	
	public ControllerMain() {
		super();
		vPrincipal = new VentanaPrincipal();
		agregarListeners();
	}
	
	
	
	public void agregarListeners() {
		vPrincipal.getPanelJuegos().getBtnF1().addActionListener(this);
		vPrincipal.getPanelJuegos().getBtnFIFA().addActionListener(this);
		vPrincipal.getPanelJuegos().getBtnGTWS().addActionListener(this);
		vPrincipal.getPanelJuegos().getBtnRocketLeague().addActionListener(this);
		vPrincipal.getPanelJuegos().getBtnLogin().addActionListener(this);
		
		vPrincipal.getPanelRocket().getBtnEquipos().addActionListener(this);
		vPrincipal.getPanelRocket().getBtnJuego().addActionListener(this);
		vPrincipal.getPanelRocket().getBtnJugadores().addActionListener(this);
		vPrincipal.getPanelRocket().getBtnLogin().addActionListener(this);
		
		vPrincipal.getPanelEquipos().getBtnJuego().addActionListener(this);
		vPrincipal.getPanelEquipos().getBtnJugadores().addActionListener(this);
		vPrincipal.getPanelEquipos().getBtnEquipos().addActionListener(this);

		vPrincipal.getPanelJugadores().getBtnJuego().addActionListener(this);
		vPrincipal.getPanelJugadores().getBtnJugadores().addActionListener(this);
		vPrincipal.getPanelJugadores().getBtnEquipos().addActionListener(this);
		
		vPrincipal.getPanelLogin().getBtnLoginForm().addActionListener(this);
		vPrincipal.getPanelMenuAdmin().getBtnEntrenadores().addActionListener(this);
		vPrincipal.getPanelMenuAdmin().getBtnJugadores().addActionListener(this);
		vPrincipal.getPanelMenuAdmin().getBtnTorneo().addActionListener(this);
		vPrincipal.getPanelMenuAdmin().getBtnEquipos().addActionListener(this);
		
		vPrincipal.getPanelGestionJugadores().getBtnAgregar().addActionListener(this);
		vPrincipal.getPanelGestionEntrenadores().getBtnAgregar().addActionListener(this);
		vPrincipal.getPanelGestionEquipos().getBtnAgregar().addActionListener(this);
		vPrincipal.getPanelGestionTorneos().getBtnAgregar().addActionListener(this);
		vPrincipal.getPanelFormula1().getBtnCarreraPasada().addActionListener(this);
		
		vPrincipal.getPanelFormula1().getBtnJuego().addActionListener(this);
		vPrincipal.getPanelFormula1().getBtnJugadores().addActionListener(this);
		vPrincipal.getPanelFormula1().getBtnEquipos().addActionListener(this);
		
		vPrincipal.getPanelEquiposFormula1().getBtnJuego().addActionListener(this);
		vPrincipal.getPanelEquiposFormula1().getBtnJugadores().addActionListener(this);
		vPrincipal.getPanelEquiposFormula1().getBtnEquipos().addActionListener(this);
		
		vPrincipal.getPanelJugadoresFormula1().getBtnJuego().addActionListener(this);
		vPrincipal.getPanelJugadoresFormula1().getBtnJugadores().addActionListener(this);
		vPrincipal.getPanelJugadoresFormula1().getBtnEquipos().addActionListener(this);





		
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		switch(comando) {
		case "btnRocketLeague":
			vPrincipal.mostrarPanel("PanelRocket");
			juegoActual = "PanelRocket";
			break;
		case "btnFormula1":
			vPrincipal.mostrarPanel("PanelFormula1");
			juegoActual = "PanelFormula1";
			break;
		case "CarreraPasada":
		    vPrincipal.mostrarPanel("PanelResultadosFormula1");
		    break;
		case "JuegoF1":
		    vPrincipal.mostrarPanel("PanelFormula1");
		    break;
		case "JugadoresF1":
		    vPrincipal.mostrarPanel("PanelJugadoresFormula1");
		    break;
		case "EquiposF1":
		    vPrincipal.mostrarPanel("PanelEquiposFormula1");
		    break;

		case "btnGTWS":
			break;
		case "btnFIFA":
			
			break;
		case "Login":
			vPrincipal.mostrarPanel("PanelLogin");
			entrenadorDAO = new EntrenadorDAO();
			break;
		case "MenuAdmin":
			vPrincipal.mostrarPanel("PanelMenuAdmin");
			break;
		case "Equipos":
		    vPrincipal.mostrarPanel("PanelGestionEquipos");
		    break;

		case "Torneos":
		    vPrincipal.mostrarPanel("PanelGestionTorneos");
		    break;
			
		case "Entrenadores":
		    vPrincipal.mostrarPanel("PanelGestionEntrenadores");
		    break;
		case "Jugadores":
		    vPrincipal.mostrarPanel("PanelGestionJugadores");
		    break;
		case "AgregarJugador":
		    vPrincipal.mostrarPanel("PanelCrearJugador");
		    break;

		case "AgregarEntrenador":
		    vPrincipal.mostrarPanel("PanelCrearEntrenador");
		    break;

		case "AgregarEquipo":
		    vPrincipal.mostrarPanel("PanelCrearEquipo");
		    break;

		case "AgregarTorneo":
		    vPrincipal.mostrarPanel("PanelCrearTorneo");
		    break;

		case "Juego":
			vPrincipal.mostrarPanel(juegoActual);
			break;
		case "btnJugadores":
			vPrincipal.mostrarPanel("PanelJugadores");
			break;
		case "btnEquipos":
			vPrincipal.mostrarPanel("PanelEquipos");
			break; 
		case "Agregar":
			entrenador = new Entrenador("Pepito", "Pepito@correo.com");
			entrenadorDAO.add(entrenador);
			break;
		default:
			System.out.println(comando);
			
		
		}
		
	}
	
	
}



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
		
		//vPrincipal.getPanelLogin().getBtnAgregarEquipo().addActionListener(this);
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
			
			break;
		case "btnGTWS":
			break;
		case "btnFIFA":
			
			break;
		case "Login":
			vPrincipal.mostrarPanel("PanelLogin");
			entrenadorDAO = new EntrenadorDAO();
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



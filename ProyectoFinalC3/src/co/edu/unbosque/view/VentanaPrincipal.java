package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private CardLayout cardLayout;
    private JPanel contenedor; // Panel principal que contiene los demás paneles
    private PanelJuegos panelJuegos;
    private PanelEquipos panelEquipos;
    private PanelJugadores panelJugadores;
    private PanelRocket panelRocket;
    private PanelLogin panelLogin;
    private PanelMenuAdmin panelMenuAdmin;
    private PanelGestionEntrenadores panelGestionEntrenadores;
    private PanelGestionJugadores panelGestionJugadores;
    private PanelCrearEntrenador panelCrearEntrenador;
    private PanelCrearEquipo panelCrearEquipo;
    private PanelCrearTorneo panelCrearTorneo;
    private PanelGestionTorneos panelGestionTorneos;
    private PanelGestionEquipos panelGestionEquipos;
    private PanelCrearJugador panelCrearJugador;

    public VentanaPrincipal() {
        setTitle("NeoLeague Arena");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setResizable(false);

        inicializarComponentes();

        setVisible(true);
    }

    private void inicializarComponentes() {
        cardLayout = new CardLayout();
        contenedor = new JPanel(cardLayout);

        // --- Crear los paneles ---
        panelJuegos = new PanelJuegos();
        panelEquipos = new PanelEquipos();
        panelJugadores = new PanelJugadores();
        panelRocket = new PanelRocket();
        panelLogin = new PanelLogin(); 
        panelMenuAdmin = new PanelMenuAdmin();
        panelGestionEntrenadores = new PanelGestionEntrenadores();
        panelGestionJugadores = new PanelGestionJugadores();
        panelGestionTorneos = new PanelGestionTorneos();
        panelGestionEquipos = new PanelGestionEquipos();
        panelCrearJugador = new PanelCrearJugador();
        panelCrearEntrenador = new PanelCrearEntrenador();
        panelCrearEquipo = new PanelCrearEquipo();
        panelCrearTorneo = new PanelCrearTorneo();
        


        // --- Agregar los paneles al contenedor ---
        contenedor.add(panelJuegos, "PanelJuegos");
        contenedor.add(panelEquipos, "PanelEquipos");
        contenedor.add(panelJugadores, "PanelJugadores");
        contenedor.add(panelRocket, "PanelRocket");
        contenedor.add(panelLogin, "PanelLogin");
        contenedor.add(panelMenuAdmin, "PanelMenuAdmin");
        contenedor.add(panelGestionEntrenadores,"PanelGestionEntrenadores");
        contenedor.add(panelGestionJugadores,"PanelGestionJugadores");
        contenedor.add(panelGestionTorneos,"PanelGestionTorneos");
        contenedor.add(panelGestionEquipos,"PanelGestionEquipos");

        contenedor.add(panelCrearJugador, "PanelCrearJugador");
        contenedor.add(panelCrearEntrenador, "PanelCrearEntrenador");
        contenedor.add(panelCrearEquipo, "PanelCrearEquipo");
        contenedor.add(panelCrearTorneo, "PanelCrearTorneo");
        
        // --- Agregar contenedor a la ventana ---
        add(contenedor);

        // --- Mostrar inicialmente el panel de juegos ---
        cardLayout.show(contenedor, "PanelLogin");

    }



    public void mostrarPanel(String nombrePanel) {
        cardLayout.show(contenedor, nombrePanel);
    }

    // --- Getters si los necesitas en controladores ---
    public PanelJuegos getPanelJuegos() {
        return panelJuegos;
    }

    public PanelEquipos getPanelEquipos() {
        return panelEquipos;
    }

    public PanelJugadores getPanelJugadores() {
        return panelJugadores;
    }
    
    public PanelRocket getPanelRocket() {
        return panelRocket;
    }
    
    public CardLayout getCardLayout() {
    	return cardLayout;
    }
    
    public JPanel getContenedor() {
    	return contenedor;
    }

    public PanelLogin getPanelLogin() {
        return panelLogin;
    }

	public PanelMenuAdmin getPanelMenuAdmin() {
		return panelMenuAdmin;
	}

	public PanelCrearEntrenador getPanelCrearEntrenador() {
		return panelCrearEntrenador;
	}

	public void setPanelCrearEntrenador(PanelCrearEntrenador panelCrearEntrenador) {
		this.panelCrearEntrenador = panelCrearEntrenador;
	}

	public PanelCrearEquipo getPanelCrearEquipo() {
		return panelCrearEquipo;
	}

	public void setPanelCrearEquipo(PanelCrearEquipo panelCrearEquipo) {
		this.panelCrearEquipo = panelCrearEquipo;
	}

	public PanelCrearTorneo getPanelCrearTorneo() {
		return panelCrearTorneo;
	}

	public void setPanelCrearTorneo(PanelCrearTorneo panelCrearTorneo) {
		this.panelCrearTorneo = panelCrearTorneo;
	}

	public PanelCrearJugador getPanelCrearJugador() {
		return panelCrearJugador;
	}

	public void setPanelCrearJugador(PanelCrearJugador panelCrearJugador) {
		this.panelCrearJugador = panelCrearJugador;
	}

	public PanelGestionEntrenadores getPanelGestionEntrenadores() {
		return panelGestionEntrenadores;
	}

	public void setPanelGestionEntrenadores(PanelGestionEntrenadores panelGestionEntrenadores) {
		this.panelGestionEntrenadores = panelGestionEntrenadores;
	}

	public PanelGestionJugadores getPanelGestionJugadores() {
		return panelGestionJugadores;
	}

	public void setPanelGestionJugadores(PanelGestionJugadores panelGestionJugadores) {
		this.panelGestionJugadores = panelGestionJugadores;
	}

	public PanelGestionTorneos getPanelGestionTorneos() {
		return panelGestionTorneos;
	}

	public void setPanelGestionTorneos(PanelGestionTorneos panelGestionTorneos) {
		this.panelGestionTorneos = panelGestionTorneos;
	}

	public PanelGestionEquipos getPanelGestionEquipos() {
		return panelGestionEquipos;
	}

	public void setPanelGestionEquipos(PanelGestionEquipos panelGestionEquipos) {
		this.panelGestionEquipos = panelGestionEquipos;
	}
    
    
}

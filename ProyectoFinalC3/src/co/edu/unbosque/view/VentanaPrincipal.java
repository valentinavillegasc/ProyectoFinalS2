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

        // --- Agregar los paneles al contenedor ---
        contenedor.add(panelJuegos, "PanelJuegos");
        contenedor.add(panelEquipos, "PanelEquipos");
        contenedor.add(panelJugadores, "PanelJugadores");
        contenedor.add(panelRocket, "PanelRocket");
        contenedor.add(panelLogin, "PanelLogin");


        // --- Agregar contenedor a la ventana ---
        add(contenedor);

        // --- Mostrar inicialmente el panel de juegos ---
        cardLayout.show(contenedor, "PanelJuegos");

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

    public JPanel getPanelLogin() {
    	return panelLogin;
    }
}

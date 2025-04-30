package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelJugadoresFormula1 extends JPanel {

    private PanelConFondo panelLogo;
    private JButton btnLogin;
    private JButton btnJuego;
    private JButton btnJugadores;
    private JButton btnEquipos;
    private JPanel panelCentral;
    private JLabel lblTituloJugadores;
    private JLabel lblFiltros;
    private JTable tablaJugadores;
    private JScrollPane scrollTabla;
    private JButton btnGenerarReporte;

    public PanelJugadoresFormula1() {
        setLayout(new BorderLayout());
        inicializarComponentes();
        setBorder(new TitledBorder("Panel de Jugadores"));
        setBackground(Color.WHITE);
    }

    private void inicializarComponentes() {

        // --- Cargar imagen como fondo ---
        panelLogo = new PanelConFondo("/imagenes/logoESport.png");
        panelLogo.setPreferredSize(new Dimension(900, 120));
        panelLogo.setLayout(new BorderLayout());

        btnLogin = new JButton("Login");
        btnLogin.setActionCommand("Login");
        btnLogin.setFocusPainted(false);
        btnLogin.setContentAreaFilled(true);
        btnLogin.setBackground(Color.LIGHT_GRAY);

        JPanel panelLogin = new JPanel(new BorderLayout());
        panelLogin.setOpaque(false);
        panelLogin.add(btnLogin, BorderLayout.EAST);

        panelLogo.add(panelLogin, BorderLayout.NORTH);

        // --- Menú de navegación ---
        JPanel barraMenu = new JPanel(new FlowLayout(FlowLayout.CENTER));
        barraMenu.setBackground(Color.GRAY);

        btnJuego = new JButton("Juego");   
        btnJuego.setActionCommand("JuegoF1");        
        btnJugadores = new JButton("Jugadores");
        btnJugadores.setActionCommand("JugadoresF1");
        btnEquipos = new JButton("Equipos");
        btnEquipos.setActionCommand("EquiposF1");
        btnJugadores.setEnabled(false); // Estamos en "Jugadores"

        barraMenu.add(btnJuego);
        barraMenu.add(btnJugadores);
        barraMenu.add(btnEquipos);

        JPanel barraSuperiorCompleta = new JPanel(new BorderLayout());
        barraSuperiorCompleta.add(panelLogo, BorderLayout.NORTH);
        barraSuperiorCompleta.add(barraMenu, BorderLayout.SOUTH);

        // --- Panel central ---
        panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        panelCentral.setBackground(Color.WHITE);

        lblTituloJugadores = new JLabel("Jugadores");
        lblTituloJugadores.setFont(new Font("Arial", Font.BOLD, 18));
        lblTituloJugadores.setAlignmentX(Component.CENTER_ALIGNMENT);

        lblFiltros = new JLabel("Filtros");
        lblFiltros.setFont(new Font("Arial", Font.BOLD, 16));
        lblFiltros.setAlignmentX(Component.CENTER_ALIGNMENT);

        String[] columnas = {"Nombre", "Equipo", "Puntos"};
        Object[][] datos = {}; // Vacío de momento

        tablaJugadores = new JTable(datos, columnas);
        scrollTabla = new JScrollPane(tablaJugadores);

        btnGenerarReporte = new JButton("Generar reporte");
        btnGenerarReporte.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnGenerarReporte.setMaximumSize(new Dimension(200, 40));

        panelCentral.add(Box.createVerticalStrut(10));
        panelCentral.add(lblTituloJugadores);
        panelCentral.add(Box.createVerticalStrut(10));
        panelCentral.add(lblFiltros);
        panelCentral.add(Box.createVerticalStrut(10));
        panelCentral.add(scrollTabla);
        panelCentral.add(Box.createVerticalStrut(10));
        panelCentral.add(btnGenerarReporte);
        panelCentral.add(Box.createVerticalStrut(10));

        // --- Agregar todo al PanelPrincipal ---
        add(barraSuperiorCompleta, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
    }

    // --- Getters para controladores ---
    public JButton getBtnLogin() {
        return btnLogin;
    }

    public JButton getBtnJuego() {
        return btnJuego;
    }

    public JButton getBtnJugadores() {
        return btnJugadores;
    }

    public JButton getBtnEquipos() {
        return btnEquipos;
    }

    public JTable getTablaJugadores() {
        return tablaJugadores;
    }

    public JButton getBtnGenerarReporte() {
        return btnGenerarReporte;
    }
}

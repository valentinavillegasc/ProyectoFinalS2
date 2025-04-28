package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelEquipos extends JPanel {

    private PanelConFondo panelLogo;
    private JButton btnLogin;
    private JButton btnJuego;
    private JButton btnJugadores;
    private JButton btnEquipos;
    private JPanel panelCentral;
    private JLabel lblTituloEquipos;
    private JLabel lblFiltros;
    private JTable tablaEquipos;
    private JScrollPane scrollTabla;
    private JButton btnGenerarReporte;

    public PanelEquipos() {
        setLayout(new BorderLayout());
        inicializarComponentes();
        setBorder(new TitledBorder("Panel de Equipos"));
        setBackground(Color.WHITE);
    }

    private void inicializarComponentes() {

        // --- Cargar imagen como fondo en el header ---
        panelLogo = new PanelConFondo("/imagenes/logoESport.png"); // Ruta corregida
        panelLogo.setPreferredSize(new Dimension(900, 120));
        panelLogo.setLayout(new BorderLayout());

        btnLogin = new JButton("Login");
        btnLogin.setActionCommand("Login");
        btnLogin.setFocusPainted(false);
        btnLogin.setBackground(Color.LIGHT_GRAY);
        btnLogin.setPreferredSize(new Dimension(100, 30));

        JPanel panelLogin = new JPanel(new BorderLayout());
        panelLogin.setOpaque(false); // Fondo transparente
        panelLogin.add(btnLogin, BorderLayout.EAST);

        panelLogo.add(panelLogin, BorderLayout.NORTH);

        // --- Menú de navegación ---
        JPanel barraMenu = new JPanel(new FlowLayout(FlowLayout.CENTER));
        barraMenu.setBackground(Color.GRAY);

        btnJuego = new JButton("Juego");   
        btnJuego.setActionCommand("Juego");        
        btnJugadores = new JButton("Jugadores");
        btnJugadores.setActionCommand("btnJugadores");
        btnEquipos = new JButton("Equipos");
        btnEquipos.setActionCommand("btnEquipos");
        btnEquipos.setEnabled(false);

        barraMenu.add(btnJuego);
        barraMenu.add(btnJugadores);
        barraMenu.add(btnEquipos);

        JPanel barraSuperiorCompleta = new JPanel(new BorderLayout());
        barraSuperiorCompleta.add(panelLogo, BorderLayout.NORTH);
        barraSuperiorCompleta.add(barraMenu, BorderLayout.SOUTH);

        // --- Panel central con contenido de Equipos ---
        panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        panelCentral.setBackground(Color.WHITE);

        lblTituloEquipos = new JLabel("Equipos");
        lblTituloEquipos.setFont(new Font("Arial", Font.BOLD, 18));
        lblTituloEquipos.setAlignmentX(Component.CENTER_ALIGNMENT);

        lblFiltros = new JLabel("Filtros");
        lblFiltros.setFont(new Font("Arial", Font.BOLD, 16));
        lblFiltros.setAlignmentX(Component.CENTER_ALIGNMENT);

        String[] columnas = {"Nombre", "País", "Entrenador", "Puntos", "Partidas Jugadas", "Ganadas", "Perdidas"};
        Object[][] datos = {}; // Vacío inicial

        tablaEquipos = new JTable(datos, columnas);
        scrollTabla = new JScrollPane(tablaEquipos);

        btnGenerarReporte = new JButton("Generar reporte");
        btnGenerarReporte.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnGenerarReporte.setMaximumSize(new Dimension(200, 40));

        panelCentral.add(Box.createVerticalStrut(10));
        panelCentral.add(lblTituloEquipos);
        panelCentral.add(Box.createVerticalStrut(10));
        panelCentral.add(lblFiltros);
        panelCentral.add(Box.createVerticalStrut(10));
        panelCentral.add(scrollTabla);
        panelCentral.add(Box.createVerticalStrut(10));
        panelCentral.add(btnGenerarReporte);
        panelCentral.add(Box.createVerticalStrut(10));

        // --- Agregar a este PanelPrincipal ---
        add(barraSuperiorCompleta, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
    }

    // --- Getters ---
    public JButton getBtnLogin() { return btnLogin; }
    public JButton getBtnJuego() { return btnJuego; }
    public JButton getBtnJugadores() { return btnJugadores; }
    public JButton getBtnEquipos() { return btnEquipos; }
    public JTable getTablaEquipos() { return tablaEquipos; }
    public JButton getBtnGenerarReporte() { return btnGenerarReporte; }
}

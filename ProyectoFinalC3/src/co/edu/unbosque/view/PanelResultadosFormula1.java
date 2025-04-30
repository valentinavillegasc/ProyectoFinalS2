package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PanelResultadosFormula1 extends JPanel {

    private PanelConFondo panelLogo;
    private JButton btnLogin;
    private JButton btnJuego, btnJugadores, btnEquipos;
    private JButton btnClasificacion, btnCarrera, btnGenerarReporte;
    private JTable tablaResultados;
    private JScrollPane scrollTabla;

    public PanelResultadosFormula1() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        // --- LOGO + LOGIN (igual que PanelRocket) ---
        panelLogo = new PanelConFondo("/imagenes/logoESport.png");
        panelLogo.setPreferredSize(new Dimension(900, 120));
        panelLogo.setLayout(new BorderLayout());

        btnLogin = new JButton("Login");
        btnLogin.setActionCommand("Login");
        btnLogin.setFocusPainted(false);
        btnLogin.setBackground(Color.LIGHT_GRAY);

        JPanel panelLogin = new JPanel(new BorderLayout());
        panelLogin.setOpaque(false);
        panelLogin.add(btnLogin, BorderLayout.EAST);
        panelLogo.add(panelLogin, BorderLayout.NORTH);

        // --- MENÚ horizontal igual que PanelRocket ---
        JPanel barraMenu = new JPanel(new FlowLayout(FlowLayout.CENTER));
        barraMenu.setBackground(Color.GRAY);

        btnJuego = new JButton("Juego");
        btnJuego.setActionCommand("Juego");
        btnJugadores = new JButton("Jugadores");
        btnJugadores.setActionCommand("btnJugadores");
        btnEquipos = new JButton("Equipos");
        btnEquipos.setActionCommand("btnEquipos");

        barraMenu.add(btnJuego);
        barraMenu.add(btnJugadores);
        barraMenu.add(btnEquipos);

        // --- Contenedor superior completo ---
        JPanel barraSuperiorCompleta = new JPanel(new BorderLayout());
        barraSuperiorCompleta.add(panelLogo, BorderLayout.NORTH);
        barraSuperiorCompleta.add(barraMenu, BorderLayout.SOUTH);

        add(barraSuperiorCompleta, BorderLayout.NORTH);

        // --- PANEL CENTRAL ---
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        panelCentral.setBackground(Color.WHITE);

        // Título Resultados
        JLabel lblTitulo = crearTitulo("Resultados");
        panelCentral.add(Box.createVerticalStrut(20));
        panelCentral.add(lblTitulo);
        panelCentral.add(Box.createVerticalStrut(10));

        // Botones Clasificación y Carrera
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelBotones.setBackground(Color.WHITE);
        btnClasificacion = crearBotonSeccion("Clasificación");
        btnCarrera = crearBotonSeccion("Carrera");
        panelBotones.add(btnClasificacion);
        panelBotones.add(btnCarrera);
        panelCentral.add(panelBotones);
        panelCentral.add(Box.createVerticalStrut(10));

        // Tabla con borde azul
        String[] columnas = {"Posición", "Nombre", "Equipo", "Puntos"};
        tablaResultados = new JTable(new Object[0][columnas.length], columnas);
        scrollTabla = new JScrollPane(tablaResultados);
        scrollTabla.setPreferredSize(new Dimension(800, 200));
        panelCentral.add(scrollTabla);
        panelCentral.add(Box.createVerticalStrut(20));

        // Botón Generar reporte
        btnGenerarReporte = new JButton("Generar reporte");
        btnGenerarReporte.setMaximumSize(new Dimension(160, 35));
        btnGenerarReporte.setBackground(Color.LIGHT_GRAY);
        btnGenerarReporte.setFocusPainted(false);

        JPanel panelReporte = new JPanel();
        panelReporte.setLayout(new BoxLayout(panelReporte, BoxLayout.X_AXIS));
        panelReporte.setBackground(Color.WHITE);
        panelReporte.add(Box.createHorizontalGlue());
        panelReporte.add(btnGenerarReporte);
        panelCentral.add(panelReporte);
        panelCentral.add(Box.createVerticalStrut(20));

        add(panelCentral, BorderLayout.CENTER);
    }

    private JLabel crearTitulo(String texto) {
        JLabel lbl = new JLabel(texto, SwingConstants.CENTER);
        lbl.setFont(new Font("Arial", Font.BOLD, 14));
        lbl.setOpaque(true);
        lbl.setBackground(new Color(220, 220, 220));
        lbl.setMaximumSize(new Dimension(600, 25));
        lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        return lbl;
    }

    private JButton crearBotonSeccion(String texto) {
        JButton btn = new JButton(texto);
        btn.setPreferredSize(new Dimension(140, 30));
        btn.setBackground(new Color(230, 230, 230));
        btn.setFocusPainted(false);
        btn.setFont(new Font("Arial", Font.BOLD, 12));
        return btn;
    }

    // --- Getters para controlador ---
    public JButton getBtnLogin() { return btnLogin; }
    public JButton getBtnJuego() { return btnJuego; }
    public JButton getBtnJugadores() { return btnJugadores; }
    public JButton getBtnEquipos() { return btnEquipos; }
    public JButton getBtnClasificacion() { return btnClasificacion; }
    public JButton getBtnCarrera() { return btnCarrera; }
    public JButton getBtnGenerarReporte() { return btnGenerarReporte; }
    public JTable getTablaResultados() { return tablaResultados; }
}

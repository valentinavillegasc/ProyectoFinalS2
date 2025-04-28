package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelRocket extends JPanel {

    private PanelConFondo panelLogo;
    private JButton btnLogin;
    private JButton btnJuego;
    private JButton btnJugadores;
    private JButton btnEquipos;
    private JPanel panelCentral;
    private JLabel lblNombreJuego;
    private JLabel lblLogoJuego;
    private JPanel panelPartidas;

    public PanelRocket() {
        setLayout(new BorderLayout());
        inicializarComponentes();
        setBorder(new TitledBorder("Panel Rocket League"));
        setBackground(Color.WHITE);
    }

    private void inicializarComponentes() {

        // --- Logo superior con fondo ---
        panelLogo = new PanelConFondo("/imagenes/logoESport.png"); // Cambia aquí si usas otro fondo
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

        // --- Menú de navegación ---
        JPanel barraMenu = new JPanel(new FlowLayout(FlowLayout.CENTER));
        barraMenu.setBackground(Color.GRAY);

        btnJuego = new JButton("Juego");
        btnJuego.setActionCommand("Juego");
        btnJuego.setEnabled(false);
        btnJugadores = new JButton("Jugadores");
        btnJugadores.setActionCommand("btnJugadores");
        btnEquipos = new JButton("Equipos");
        btnEquipos.setActionCommand("btnEquipos");

        barraMenu.add(btnJuego);
        barraMenu.add(btnJugadores);
        barraMenu.add(btnEquipos);

        JPanel barraSuperiorCompleta = new JPanel(new BorderLayout());
        barraSuperiorCompleta.add(panelLogo, BorderLayout.NORTH);
        barraSuperiorCompleta.add(barraMenu, BorderLayout.SOUTH);

        // --- Panel central (Nombre del juego + Logo + Partidas) ---
        panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        panelCentral.setBackground(Color.WHITE);

        lblNombreJuego = new JLabel("Rocket League", SwingConstants.CENTER);
        lblNombreJuego.setFont(new Font("Arial", Font.BOLD, 18));
        lblNombreJuego.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelCentral.add(Box.createVerticalStrut(10));
        panelCentral.add(lblNombreJuego);
        panelCentral.add(Box.createVerticalStrut(20));

        // --- Logo del juego ---
        lblLogoJuego = new JLabel(new ImageIcon(getClass().getResource("/imagenes/logoRocket.png")));
        lblLogoJuego.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblLogoJuego.setPreferredSize(new Dimension(200, 200));

        panelCentral.add(lblLogoJuego);
        panelCentral.add(Box.createVerticalStrut(20));

        // --- Panel de partidas ---
        panelPartidas = new JPanel();
        panelPartidas.setLayout(new BoxLayout(panelPartidas, BoxLayout.Y_AXIS));
        panelPartidas.setBackground(Color.WHITE);
        panelPartidas.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Crear algunos partidos de ejemplo
        panelPartidas.add(crearPartida("Equipo 1", "Equipo 2", "Fin 12/4", "Fase de grupos"));
        panelPartidas.add(Box.createVerticalStrut(10));
        panelPartidas.add(crearPartida("Equipo 3", "Equipo 4", "Por definirse 15/4", "Octavos de final"));
        panelPartidas.add(Box.createVerticalStrut(10));
        panelPartidas.add(crearPartida("Equipo 5", "Equipo 6", "Por definirse 18/4", "Cuartos de final"));

        panelCentral.add(panelPartidas);

        // --- Agregar todo al PanelPrincipal ---
        add(barraSuperiorCompleta, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
    }

    private JPanel crearPartida(String equipo1, String equipo2, String fecha, String fase) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 3));
        panel.setBackground(new Color(230, 230, 230));
        panel.setMaximumSize(new Dimension(400, 60));

        JLabel lblEquipo1 = new JLabel(equipo1, SwingConstants.CENTER);
        lblEquipo1.setForeground(new Color(0, 153, 0)); // Verde

        JLabel lblEquipo2 = new JLabel(equipo2, SwingConstants.CENTER);
        lblEquipo2.setForeground(new Color(153, 0, 0)); // Rojo oscuro

        JLabel lblFecha = new JLabel(fecha, SwingConstants.CENTER);
        JLabel lblFase = new JLabel(fase, SwingConstants.CENTER);

        panel.add(lblEquipo1);
        panel.add(new JLabel("#", SwingConstants.CENTER)); // Placeholder para marcador
        panel.add(lblFecha);
        panel.add(lblEquipo2);
        panel.add(new JLabel("#", SwingConstants.CENTER));
        panel.add(lblFase);

        return panel;
    }

    // --- Getters para controladores ---
    public JButton getBtnLogin() { return btnLogin; }
    public JButton getBtnJuego() { return btnJuego; }
    public JButton getBtnJugadores() { return btnJugadores; }
    public JButton getBtnEquipos() { return btnEquipos; }
}

package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelMenuAdmin extends JPanel {

    private PanelConFondo panelLogo;
    private JButton btnLogin;
    private JPanel panelCentral;
    private JLabel lblMenuTitulo;
    private JButton btnTorneo;
    private JButton btnResultados;
    private JButton btnEntrenadores;
    private JButton btnEquipos;
    private JButton btnJugadores;

    public PanelMenuAdmin() {
        setLayout(new BorderLayout());
        inicializarComponentes();
        setBorder(new TitledBorder("Menú Administradores"));
        setBackground(Color.WHITE);
    }

    private void inicializarComponentes() {

        // --- Logo superior con fondo ---
        panelLogo = new PanelConFondo("/imagenes/logoESport.png");
        panelLogo.setPreferredSize(new Dimension(900, 120));
        panelLogo.setLayout(new BorderLayout());

        btnLogin = new JButton("Login");
        btnLogin.setFocusPainted(false);
        btnLogin.setBackground(Color.LIGHT_GRAY);

        JPanel panelLogin = new JPanel(new BorderLayout());
        panelLogin.setOpaque(false);
        panelLogin.add(btnLogin, BorderLayout.EAST);

        panelLogo.add(panelLogin, BorderLayout.NORTH);

        // --- Panel central ---
        panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        panelCentral.setBackground(Color.WHITE);

        lblMenuTitulo = new JLabel("Menú", SwingConstants.CENTER);
        lblMenuTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblMenuTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelCentral.add(Box.createVerticalStrut(20));
        panelCentral.add(lblMenuTitulo);
        panelCentral.add(Box.createVerticalStrut(30));

        // --- Botones de menú ---
        JPanel panelBotonesArriba = new JPanel(new GridLayout(1, 3, 20, 20));
        panelBotonesArriba.setBackground(Color.WHITE);
        panelBotonesArriba.setMaximumSize(new Dimension(600, 100));
        panelBotonesArriba.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnTorneo = crearBotonMenu("Torneos");
        btnResultados = crearBotonMenu("Resultados");
        btnEntrenadores = crearBotonMenu("Entrenadores");

        panelBotonesArriba.add(btnTorneo);
        panelBotonesArriba.add(btnResultados);
        panelBotonesArriba.add(btnEntrenadores);

        JPanel panelBotonesAbajo = new JPanel(new GridLayout(1, 2, 20, 20));
        panelBotonesAbajo.setBackground(Color.WHITE);
        panelBotonesAbajo.setMaximumSize(new Dimension(400, 100));
        panelBotonesAbajo.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnEquipos = crearBotonMenu("Equipos");
        btnJugadores = crearBotonMenu("Jugadores");

        panelBotonesAbajo.add(btnEquipos);
        panelBotonesAbajo.add(btnJugadores);

        panelCentral.add(panelBotonesArriba);
        panelCentral.add(Box.createVerticalStrut(30));
        panelCentral.add(panelBotonesAbajo);

        // --- Agregar todo al principal ---
        add(panelLogo, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
    }

    private JButton crearBotonMenu(String texto) {
        JButton boton = new JButton(texto);
        boton.setFocusPainted(false);
        boton.setBackground(new Color(220, 220, 220));
        boton.setFont(new Font("Arial", Font.BOLD, 14));
        return boton;
    }

    // --- Getters para controladores ---
    public JButton getBtnLogin() {
        return btnLogin;
    }

    public JButton getBtnTorneo() {
        return btnTorneo;
    }

    public JButton getBtnResultados() {
        return btnResultados;
    }

    public JButton getBtnEntrenadores() {
        return btnEntrenadores;
    }

    public JButton getBtnEquipos() {
        return btnEquipos;
    }

    public JButton getBtnJugadores() {
        return btnJugadores;
    }
}

package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelFormula1 extends JPanel {

    private PanelConFondo panelLogo;
    private JButton btnLogin;
    private JButton btnJuego, btnJugadores, btnEquipos;
    private JButton btnCarreraPasada, btnCarreraProxima;

    public PanelFormula1() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        // --- LOGO SUPERIOR CON LOGIN (igual que PanelRocket) ---
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

        // --- MENÚ DE NAVEGACIÓN (igual a PanelRocket) ---
        JPanel barraMenu = new JPanel(new FlowLayout(FlowLayout.CENTER));
        barraMenu.setBackground(Color.GRAY);

        btnJuego = new JButton("Juego");   
        btnJuego.setActionCommand("JuegoF1");        
        btnJugadores = new JButton("Jugadores");
        btnJugadores.setActionCommand("JugadoresF1");
        btnEquipos = new JButton("Equipos");
        btnEquipos.setActionCommand("EquiposF1");

        barraMenu.add(btnJuego);
        barraMenu.add(btnJugadores);
        barraMenu.add(btnEquipos);

        // --- CONTENEDOR SUPERIOR COMPLETO ---
        JPanel barraSuperiorCompleta = new JPanel(new BorderLayout());
        barraSuperiorCompleta.add(panelLogo, BorderLayout.NORTH);
        barraSuperiorCompleta.add(barraMenu, BorderLayout.SOUTH);
        add(barraSuperiorCompleta, BorderLayout.NORTH);

        // --- PANEL CENTRAL ---
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        panelCentral.setBackground(Color.WHITE);

        JLabel lblTitulo = new JLabel("F1 Sim Racing World Championship", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setOpaque(true);
        lblTitulo.setBackground(new Color(220, 220, 220));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblTitulo.setMaximumSize(new Dimension(600, 30));

        panelCentral.add(Box.createVerticalStrut(20));
        panelCentral.add(lblTitulo);
        panelCentral.add(Box.createVerticalStrut(20));

        // --- CONTENIDO PRINCIPAL ---
        JPanel panelContenido = new JPanel();
        panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.X_AXIS));
        panelContenido.setBackground(Color.WHITE);

        // Logo del juego
     // Logo del juego (imagen real)
        JPanel panelLogoJuego = new JPanel();
        panelLogoJuego.setPreferredSize(new Dimension(300, 300));
        panelLogoJuego.setBackground(Color.WHITE);

        ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/logoFormula1.png"));
        Image imagenEscalada = icono.getImage().getScaledInstance(500, 350, Image.SCALE_SMOOTH);
        JLabel lblLogoJuego = new JLabel(new ImageIcon(imagenEscalada));
        lblLogoJuego.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelLogoJuego.add(lblLogoJuego);


        // Panel carreras
        JPanel panelCarreras = new JPanel();
        panelCarreras.setLayout(new BoxLayout(panelCarreras, BoxLayout.Y_AXIS));
        panelCarreras.setBackground(Color.WHITE);
        panelCarreras.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));

        JLabel lblCarreras = new JLabel("Carreras", SwingConstants.CENTER);
        lblCarreras.setFont(new Font("Arial", Font.BOLD, 14));
        lblCarreras.setOpaque(true);
        lblCarreras.setBackground(new Color(220, 220, 220));
        lblCarreras.setMaximumSize(new Dimension(300, 25));

        panelCarreras.add(lblCarreras);
        panelCarreras.add(Box.createVerticalStrut(10));

        // Botones de carrera
        btnCarreraPasada = crearBotonCarrera("Pasado", "España", "12/05", "1. Luis", "2. Ana", "3. Leo");
        btnCarreraPasada.setActionCommand("CarreraPasada");

        btnCarreraProxima = crearBotonCarrera("Próximo", "Italia", "22/06", "1. -----", "2. -----", "3. -----");
        btnCarreraProxima.setActionCommand("CarreraProxima");

        panelCarreras.add(btnCarreraPasada);
        panelCarreras.add(Box.createVerticalStrut(10));
        panelCarreras.add(btnCarreraProxima);

        // Ensamblar contenido
        panelContenido.add(Box.createHorizontalStrut(20));
        panelContenido.add(panelLogoJuego);
        panelContenido.add(panelCarreras);
        panelContenido.add(Box.createHorizontalStrut(20));

        panelCentral.add(panelContenido);
        panelCentral.add(Box.createVerticalStrut(30));

        add(panelCentral, BorderLayout.CENTER);
    }

    private JButton crearBotonMenu(String texto) {
        JButton btn = new JButton(texto);
        btn.setFocusPainted(false);
        btn.setPreferredSize(new Dimension(100, 30));
        btn.setFont(new Font("Arial", Font.BOLD, 13));
        return btn;
    }

    private JButton crearBotonCarrera(String titulo, String pais, String fecha, String j1, String j2, String j3) {
        String html = "<html><b>" + titulo + "</b><br>"
                + pais + " - " + fecha + "<br>"
                + j1 + "&emsp;" + j2 + "&emsp;" + j3 + "</html>";

        JButton btn = new JButton(html);
        btn.setBackground(new Color(230, 230, 230));
        btn.setFocusPainted(false);
        btn.setFont(new Font("Arial", Font.PLAIN, 12));
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setVerticalAlignment(SwingConstants.TOP);
        btn.setPreferredSize(new Dimension(300, 80));
        btn.setMaximumSize(new Dimension(300, 80));
        return btn;
    }

    // --- Getters ---
    public JButton getBtnLogin() { return btnLogin; }
    public JButton getBtnJuego() { return btnJuego; }
    public JButton getBtnJugadores() { return btnJugadores; }
    public JButton getBtnEquipos() { return btnEquipos; }
    public JButton getBtnCarreraPasada() { return btnCarreraPasada; }
    public JButton getBtnCarreraProxima() { return btnCarreraProxima; }
}

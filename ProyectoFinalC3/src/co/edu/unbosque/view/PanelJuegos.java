package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelJuegos extends JPanel {

    private PanelConFondo panelLogo; // Ahora usamos PanelConFondo
    private JButton btnLogin;
    private JPanel panelCentral;
    private JLabel lblBienvenida;
    private JButton btnF1;
    private JButton btnGTWS;
    private JButton btnFIFA;
    private JButton btnRocketLeague;

    public PanelJuegos() {
        setLayout(new BorderLayout());
        inicializarComponentes();
        setBorder(new TitledBorder("Panel de Juegos"));
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

        // --- Panel central ---
        panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        panelCentral.setBackground(Color.WHITE);

        lblBienvenida = new JLabel("Bienvenido a NeoLeague Arena", SwingConstants.CENTER);
        lblBienvenida.setFont(new Font("Arial", Font.BOLD, 18));
        lblBienvenida.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelCentral.add(Box.createVerticalStrut(20));
        panelCentral.add(lblBienvenida);
        panelCentral.add(Box.createVerticalStrut(20));

        // --- Panel de botones ---
        JPanel panelBotones = new JPanel(new GridLayout(2, 2, 30, 30));
        panelBotones.setMaximumSize(new Dimension(600, 400));
        panelBotones.setBackground(Color.WHITE);
        panelBotones.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnF1 = new JButton(escalarImagen("/imagenes/logoFormula1.png", 350, 170));
        btnF1.setActionCommand("btnFormula1");
        btnGTWS = new JButton(escalarImagen("/imagenes/logoGranTurismo.png", 350, 170));
        btnGTWS.setActionCommand("btnGTWS");
        btnFIFA = new JButton(escalarImagen("/imagenes/logoFifa.png", 350, 170));
        btnFIFA.setActionCommand("btnFIFA");
        btnRocketLeague = new JButton(escalarImagen("/imagenes/logoRocket.png", 350, 170));
        btnRocketLeague.setActionCommand("btnRocketLeague");

        personalizarBotonJuego(btnF1);
        personalizarBotonJuego(btnGTWS);
        personalizarBotonJuego(btnFIFA);
        personalizarBotonJuego(btnRocketLeague);

        panelBotones.add(btnF1);
        panelBotones.add(btnGTWS);
        panelBotones.add(btnFIFA);
        panelBotones.add(btnRocketLeague);

        panelCentral.add(panelBotones);

        // --- Agregar todo al panel principal ---
        add(panelLogo, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
    }

    private void personalizarBotonJuego(JButton boton) {
        boton.setFocusPainted(false);
        boton.setContentAreaFilled(false);
        boton.setBorderPainted(false);
        boton.setHorizontalAlignment(SwingConstants.CENTER);
        boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private ImageIcon escalarImagen(String ruta, int ancho, int alto) {
        ImageIcon iconoOriginal = new ImageIcon(getClass().getResource(ruta));
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imagenEscalada);
    }

    // --- Getters ---
    public JButton getBtnLogin() {
        return btnLogin;
    }

    public JButton getBtnF1() {
        return btnF1;
    }

    public JButton getBtnGTWS() {
        return btnGTWS;
    }

    public JButton getBtnFIFA() {
        return btnFIFA;
    }

    public JButton getBtnRocketLeague() {
        return btnRocketLeague;
    }
}

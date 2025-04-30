package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelLogin extends JPanel {

    private PanelConFondo panelLogo;
    private JButton btnLoginHeader;
    private JPanel panelCentral;
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    private JButton btnLoginForm;

    public PanelLogin() {
        setLayout(new BorderLayout());
        setBorder(new TitledBorder("Panel de Inicio de Sesión"));
        setBackground(Color.WHITE);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        // --- Panel superior: Logo + botón login ---
        panelLogo = new PanelConFondo("/imagenes/logoESport.png");
        panelLogo.setPreferredSize(new Dimension(900, 120));
        panelLogo.setLayout(new BorderLayout());

        btnLoginHeader = new JButton("Login");
        btnLoginHeader.setFocusPainted(false);
        btnLoginHeader.setBackground(Color.LIGHT_GRAY);

        JPanel panelLoginHeader = new JPanel(new BorderLayout());
        panelLoginHeader.setOpaque(false);
        panelLoginHeader.add(btnLoginHeader, BorderLayout.EAST);

        panelLogo.add(panelLoginHeader, BorderLayout.NORTH);
        add(panelLogo, BorderLayout.NORTH);

        // --- Panel central: título + formulario ---
        panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        panelCentral.setBackground(Color.WHITE);

        JLabel lblTituloLogin = new JLabel("Login", SwingConstants.CENTER);
        lblTituloLogin.setFont(new Font("Arial", Font.BOLD, 16));
        lblTituloLogin.setOpaque(true);
        lblTituloLogin.setBackground(new Color(220, 220, 220));
        lblTituloLogin.setMaximumSize(new Dimension(300, 30));
        lblTituloLogin.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelCentral.add(Box.createVerticalStrut(20));
        panelCentral.add(lblTituloLogin);
        panelCentral.add(Box.createVerticalStrut(30));

        // --- Formulario de login ---
        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new BoxLayout(panelFormulario, BoxLayout.Y_AXIS));
        panelFormulario.setBackground(new Color(230, 230, 230));
        panelFormulario.setMaximumSize(new Dimension(400, 200));
        panelFormulario.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setFont(new Font("Arial", Font.BOLD, 14));
        txtUsuario = new JTextField();
        txtUsuario.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setFont(new Font("Arial", Font.BOLD, 14));
        txtContrasena = new JPasswordField();
        txtContrasena.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        btnLoginForm = new JButton("Login");
        btnLoginForm.setActionCommand("MenuAdmin");
        btnLoginForm.setFocusPainted(false);
        btnLoginForm.setBackground(Color.LIGHT_GRAY);
        btnLoginForm.setMaximumSize(new Dimension(100, 30));
        btnLoginForm.setAlignmentX(Component.RIGHT_ALIGNMENT);

        panelFormulario.add(lblUsuario);
        panelFormulario.add(Box.createVerticalStrut(5));
        panelFormulario.add(txtUsuario);
        panelFormulario.add(Box.createVerticalStrut(15));
        panelFormulario.add(lblContrasena);
        panelFormulario.add(Box.createVerticalStrut(5));
        panelFormulario.add(txtContrasena);
        panelFormulario.add(Box.createVerticalStrut(20));
        panelFormulario.add(btnLoginForm);

        panelCentral.add(panelFormulario);
        panelCentral.add(Box.createVerticalStrut(30));

        add(panelCentral, BorderLayout.CENTER);
    }

    // --- Getters para controladores ---
    public JButton getBtnLoginForm() { return btnLoginForm; }
    public JButton getBtnLoginHeader() { return btnLoginHeader; }
    public JTextField getTxtUsuario() { return txtUsuario; }
    public JPasswordField getTxtContrasena() { return txtContrasena; }
}

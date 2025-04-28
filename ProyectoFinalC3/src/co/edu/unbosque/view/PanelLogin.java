package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelLogin extends JPanel {

    private PanelConFondo panelLogo;
    private JButton btnLogin;
    private JButton btnAgregarEquipo;
    private JButton btnEliminarEquipo;
    private JButton btnDefinirTorneo;
    private JButton btnConfigurarPartida;
    private JLabel lblTituloAdmin;

    public PanelLogin() {
        setLayout(new BorderLayout());
        inicializarComponentes();
        setBorder(new TitledBorder("Panel de Administración"));
        setBackground(Color.WHITE);
    }

    private void inicializarComponentes() {

        // --- Header con logo y login ---
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

        // --- Centro de administración ---
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        panelCentral.setBackground(Color.WHITE);

        lblTituloAdmin = new JLabel("Panel de Administración", SwingConstants.CENTER);
        lblTituloAdmin.setFont(new Font("Arial", Font.BOLD, 22));
        lblTituloAdmin.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelCentral.add(Box.createVerticalStrut(20));
        panelCentral.add(lblTituloAdmin);
        panelCentral.add(Box.createVerticalStrut(30));

        // --- Botones de acciones ---
        btnAgregarEquipo = new JButton("Agregar Equipo");
        btnAgregarEquipo.setActionCommand("Agregar");
        btnEliminarEquipo = new JButton("Eliminar Equipo");
        btnDefinirTorneo = new JButton("Definir Torneo Actual");
        btnConfigurarPartida = new JButton("Configurar Partida (Quién vs Quién)");

        personalizarBoton(btnAgregarEquipo);
        personalizarBoton(btnEliminarEquipo);
        personalizarBoton(btnDefinirTorneo);
        personalizarBoton(btnConfigurarPartida);

        panelCentral.add(btnAgregarEquipo);
        panelCentral.add(Box.createVerticalStrut(15));
        panelCentral.add(btnEliminarEquipo);
        panelCentral.add(Box.createVerticalStrut(15));
        panelCentral.add(btnDefinirTorneo);
        panelCentral.add(Box.createVerticalStrut(15));
        panelCentral.add(btnConfigurarPartida);

        // --- Agregar al principal ---
        add(panelLogo, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
    }

    private void personalizarBoton(JButton boton) {
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton.setMaximumSize(new Dimension(300, 40));
        boton.setFocusPainted(false);
        boton.setBackground(new Color(70, 130, 180));
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Arial", Font.BOLD, 14));
    }

    // --- Getters para controladores ---
    public JButton getBtnLogin() {
        return btnLogin;
    }

    public JButton getBtnAgregarEquipo() {
        return btnAgregarEquipo;
    }

    public JButton getBtnEliminarEquipo() {
        return btnEliminarEquipo;
    }

    public JButton getBtnDefinirTorneo() {
        return btnDefinirTorneo;
    }

    public JButton getBtnConfigurarPartida() {
        return btnConfigurarPartida;
    }
}

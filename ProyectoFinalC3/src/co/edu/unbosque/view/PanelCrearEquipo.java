package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelCrearEquipo extends JPanel {

    private PanelConFondo panelLogo;
    private JTextField txtNombre;
    private JComboBox<String> comboJuego;
    private JComboBox<String> comboEntrenador;
    private JTextField txtCiudad;
    private JButton btnGuardar;

    public PanelCrearEquipo() {
        setLayout(new BorderLayout());
        setBorder(new TitledBorder("Crear Equipo"));
        setBackground(Color.WHITE);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        // --- Logo superior ---
        panelLogo = new PanelConFondo("/imagenes/logoESport.png");
        panelLogo.setPreferredSize(new Dimension(900, 120));
        panelLogo.setLayout(new BorderLayout());

        add(panelLogo, BorderLayout.NORTH);

        // --- Panel Central ---
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        panelCentral.setBackground(Color.WHITE);

        // --- Título ---
        JLabel lblTitulo = new JLabel("Crear Equipo", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setOpaque(true);
        lblTitulo.setBackground(new Color(220, 220, 220));
        lblTitulo.setMaximumSize(new Dimension(600, 30));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCentral.add(Box.createVerticalStrut(15));
        panelCentral.add(lblTitulo);
        panelCentral.add(Box.createVerticalStrut(20));

        // --- Formulario ---
        JPanel panelFormulario = new JPanel(new GridLayout(4, 2, 10, 15));
        panelFormulario.setMaximumSize(new Dimension(500, 150));
        panelFormulario.setBackground(Color.WHITE);

        panelFormulario.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelFormulario.add(txtNombre);

        panelFormulario.add(new JLabel("Juego:"));
        comboJuego = new JComboBox<>(new String[]{"Seleccionar...", "FIFA", "Formula 1", "Gran turismo", "Rocket League"});
        panelFormulario.add(comboJuego);

        panelFormulario.add(new JLabel("Entrenador:"));
        comboEntrenador = new JComboBox<>(new String[]{"Seleccionar...", "Entrenador 1", "Entrenador 2"});
        panelFormulario.add(comboEntrenador);

        panelFormulario.add(new JLabel("Ciudad:"));
        txtCiudad = new JTextField();
        panelFormulario.add(txtCiudad);

        panelCentral.add(panelFormulario);
        panelCentral.add(Box.createVerticalStrut(20));

        // --- Botón Guardar ---
        btnGuardar = new JButton("Guardar");
        btnGuardar.setFocusPainted(false);
        btnGuardar.setBackground(new Color(210, 210, 210));
        btnGuardar.setFont(new Font("Arial", Font.BOLD, 14));
        btnGuardar.setMaximumSize(new Dimension(120, 35));
        btnGuardar.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelCentral.add(btnGuardar);
        panelCentral.add(Box.createVerticalStrut(20));

        add(panelCentral, BorderLayout.CENTER);
    }

    // --- Getters ---
    public JTextField getTxtNombre() { return txtNombre; }
    public JComboBox<String> getComboJuego() { return comboJuego; }
    public JComboBox<String> getComboEntrenador() { return comboEntrenador; }
    public JTextField getTxtCiudad() { return txtCiudad; }
    public JButton getBtnGuardar() { return btnGuardar; }
}

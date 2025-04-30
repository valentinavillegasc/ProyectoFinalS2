package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelCrearTorneo extends JPanel {

    private PanelConFondo panelLogo;
    private JTextField txtNombre;
    private JComboBox<String> comboJuego;
    private JComboBox<String> comboTipoTorneo;
    private JTextField txtFecha;
    private JComboBox<String> comboEquipoA;
    private JComboBox<String> comboEquipoB;
    private JButton btnGuardar;

    public PanelCrearTorneo() {
        setLayout(new BorderLayout());
        setBorder(new TitledBorder("Crear Torneo"));
        setBackground(Color.WHITE);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        // --- Logo superior ---
        panelLogo = new PanelConFondo("/imagenes/logoESport.png");
        panelLogo.setPreferredSize(new Dimension(900, 120));
        panelLogo.setLayout(new BorderLayout());

        add(panelLogo, BorderLayout.NORTH);

        // --- Panel central ---
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        panelCentral.setBackground(Color.WHITE);

        // --- Título ---
        JLabel lblTitulo = new JLabel("Crear Torneo", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setOpaque(true);
        lblTitulo.setBackground(new Color(220, 220, 220));
        lblTitulo.setMaximumSize(new Dimension(600, 30));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelCentral.add(Box.createVerticalStrut(15));
        panelCentral.add(lblTitulo);
        panelCentral.add(Box.createVerticalStrut(20));

        // --- Formulario ---
        JPanel panelFormulario = new JPanel(new GridLayout(6, 2, 10, 15));
        panelFormulario.setMaximumSize(new Dimension(500, 200));
        panelFormulario.setBackground(Color.WHITE);

        txtNombre = new JTextField();
        comboJuego = new JComboBox<>(new String[]{"Seleccionar...", "FIFA", "Formula 1", "Gran turismo", "Rocket League"});
        comboTipoTorneo = new JComboBox<>(new String[]{"Seleccionar...", "Eliminación", "Liga", "Grupos"});
        txtFecha = new JTextField();
        comboEquipoA = new JComboBox<>(new String[]{"Seleccionar...", "Equipo 1", "Equipo 2"});
        comboEquipoB = new JComboBox<>(new String[]{"Seleccionar...", "Equipo 1", "Equipo 2"});

        panelFormulario.add(new JLabel("Nombre:"));
        panelFormulario.add(txtNombre);
        panelFormulario.add(new JLabel("Juego:"));
        panelFormulario.add(comboJuego);
        panelFormulario.add(new JLabel("Tipo de torneo:"));
        panelFormulario.add(comboTipoTorneo);
        panelFormulario.add(new JLabel("Fecha:"));
        panelFormulario.add(txtFecha);
        panelFormulario.add(new JLabel("Equipo A:"));
        panelFormulario.add(comboEquipoA);
        panelFormulario.add(new JLabel("Equipo B:"));
        panelFormulario.add(comboEquipoB);

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
    public JComboBox<String> getComboTipoTorneo() { return comboTipoTorneo; }
    public JTextField getTxtFecha() { return txtFecha; }
    public JComboBox<String> getComboEquipoA() { return comboEquipoA; }
    public JComboBox<String> getComboEquipoB() { return comboEquipoB; }
    public JButton getBtnGuardar() { return btnGuardar; }
}

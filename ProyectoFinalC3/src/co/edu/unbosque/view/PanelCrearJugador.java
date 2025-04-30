package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelCrearJugador extends JPanel {

    private PanelConFondo panelLogo;
    private JTextField txtNombre;
    private JComboBox<String> comboJuego;
    private JComboBox<String> comboEquipo;
    private JTextField txtPais;
    private JTextField txtCorreo;
    private JButton btnGuardar;

    public PanelCrearJugador() {
        setLayout(new BorderLayout());
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
        JLabel lblTitulo = new JLabel("Crear jugador", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setOpaque(true);
        lblTitulo.setBackground(new Color(220, 220, 220));
        lblTitulo.setMaximumSize(new Dimension(600, 30));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCentral.add(Box.createVerticalStrut(20));
        panelCentral.add(lblTitulo);
        panelCentral.add(Box.createVerticalStrut(20));

        // --- Formulario ---
        JPanel panelFormulario = new JPanel(new GridLayout(5, 2, 10, 15));
        panelFormulario.setMaximumSize(new Dimension(500, 200));
        panelFormulario.setBackground(Color.LIGHT_GRAY);

        panelFormulario.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelFormulario.add(txtNombre);

        panelFormulario.add(new JLabel("Juego:"));
        comboJuego = new JComboBox<>(new String[]{"Seleccionar...", "FIFA", "LoL", "Valorant"});
        panelFormulario.add(comboJuego);

        panelFormulario.add(new JLabel("Equipo:"));
        comboEquipo = new JComboBox<>(new String[]{"Seleccionar...", "Equipo A", "Equipo B"});
        panelFormulario.add(comboEquipo);

        panelFormulario.add(new JLabel("País:"));
        txtPais = new JTextField();
        panelFormulario.add(txtPais);

        panelFormulario.add(new JLabel("Correo:"));
        txtCorreo = new JTextField();
        panelFormulario.add(txtCorreo);

        panelCentral.add(panelFormulario);
        panelCentral.add(Box.createVerticalStrut(30));

        // --- Botón Guardar ---
        btnGuardar = new JButton("Guardar");
        btnGuardar.setFocusPainted(false);
        btnGuardar.setBackground(new Color(210, 210, 210));
        btnGuardar.setFont(new Font("Arial", Font.BOLD, 14));
        btnGuardar.setMaximumSize(new Dimension(120, 35));
        btnGuardar.setAlignmentX(Component.RIGHT_ALIGNMENT);
        panelCentral.add(btnGuardar);
        panelCentral.add(Box.createVerticalStrut(20));

        add(panelCentral, BorderLayout.CENTER);
    }

    // --- Getters ---
    public JTextField getTxtNombre() { return txtNombre; }
    public JComboBox<String> getComboJuego() { return comboJuego; }
    public JComboBox<String> getComboEquipo() { return comboEquipo; }
    public JTextField getTxtPais() { return txtPais; }
    public JTextField getTxtCorreo() { return txtCorreo; }
    public JButton getBtnGuardar() { return btnGuardar; }
}

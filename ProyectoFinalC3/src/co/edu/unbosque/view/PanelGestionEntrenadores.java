package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelGestionEntrenadores extends JPanel {

    private PanelConFondo panelLogo;
    private JButton btnLogin;
    private JButton btnAgregar;
    private JButton btnEditar;
    private JButton btnEliminar;
    private JTable tablaDatos;
    private JScrollPane scrollTabla;
    private JButton btnGenerarReporte;

    private JComboBox<String> comboEquipo;
    private JComboBox<String> comboPais;

    public PanelGestionEntrenadores() {
        setLayout(new BorderLayout());
        setBorder(new TitledBorder("Gestión Entrenadores"));
        setBackground(Color.WHITE);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        // --- Logo superior con botón login ---
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
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        panelCentral.setBackground(Color.WHITE);

        // --- Título visual ---
        JLabel lblTitulo = new JLabel("Gestión Entrenadores", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setOpaque(true);
        lblTitulo.setBackground(new Color(220, 220, 220));
        lblTitulo.setMaximumSize(new Dimension(500, 30));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCentral.add(Box.createVerticalStrut(20));
        panelCentral.add(lblTitulo);
        panelCentral.add(Box.createVerticalStrut(15));

        // --- Botones: Agregar, Editar, Eliminar ---
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelBotones.setBackground(Color.WHITE);

        btnAgregar = crearBoton("Agregar");
        btnAgregar.setActionCommand("AgregarEntrenador");
        btnEditar = crearBoton("Editar");
        btnEliminar = crearBoton("Eliminar");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);
        panelCentral.add(panelBotones);
        panelCentral.add(Box.createVerticalStrut(10));

        // --- Filtros con ComboBoxes (solo Equipo y País) ---
        JPanel panelFiltros = new JPanel(new GridLayout(1, 4, 10, 10));
        panelFiltros.setMaximumSize(new Dimension(600, 40));
        panelFiltros.setBackground(Color.WHITE);

        panelFiltros.add(new JLabel("Equipo:"));
        comboEquipo = new JComboBox<>(new String[]{"Todos", "Equipo A", "Equipo B"});
        panelFiltros.add(comboEquipo);

        panelFiltros.add(new JLabel("País:"));
        comboPais = new JComboBox<>(new String[]{"Todos", "Colombia", "España", "México"});
        panelFiltros.add(comboPais);

        panelCentral.add(panelFiltros);
        panelCentral.add(Box.createVerticalStrut(10));

        // --- Tabla de datos (actualizada) ---
        String[] columnas = {"Nombre","Equipo", "País"};
        Object[][] datos = {}; // Inicialmente vacío
        tablaDatos = new JTable(datos, columnas);
        scrollTabla = new JScrollPane(tablaDatos);
        scrollTabla.setPreferredSize(new Dimension(800, 250));
        scrollTabla.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCentral.add(scrollTabla);
        panelCentral.add(Box.createVerticalStrut(10));

        // --- Botón de reporte ---
        btnGenerarReporte = new JButton("Generar reporte");
        btnGenerarReporte.setFocusPainted(false);
        btnGenerarReporte.setBackground(Color.LIGHT_GRAY);
        btnGenerarReporte.setMaximumSize(new Dimension(160, 35));

        JPanel panelBotonReporte = new JPanel();
        panelBotonReporte.setLayout(new BoxLayout(panelBotonReporte, BoxLayout.X_AXIS));
        panelBotonReporte.setBackground(Color.WHITE);
        panelBotonReporte.add(Box.createHorizontalGlue());
        panelBotonReporte.add(btnGenerarReporte);
        panelBotonReporte.setMaximumSize(new Dimension(800, 40));

        panelCentral.add(panelBotonReporte);
        panelCentral.add(Box.createVerticalStrut(10));

        // --- Agregar a la vista principal ---
        add(panelLogo, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
    }

    private JButton crearBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setFocusPainted(false);
        boton.setPreferredSize(new Dimension(100, 35));
        boton.setBackground(new Color(210, 210, 210));
        boton.setFont(new Font("Arial", Font.BOLD, 14));
        return boton;
    }

    // --- Getters ---
    public JButton getBtnLogin() { return btnLogin; }
    public JButton getBtnAgregar() { return btnAgregar; }
    public JButton getBtnEditar() { return btnEditar; }
    public JButton getBtnEliminar() { return btnEliminar; }
    public JButton getBtnGenerarReporte() { return btnGenerarReporte; }
    public JTable getTablaDatos() { return tablaDatos; }

    public JComboBox<String> getComboEquipo() { return comboEquipo; }
    public JComboBox<String> getComboPais() { return comboPais; }
}

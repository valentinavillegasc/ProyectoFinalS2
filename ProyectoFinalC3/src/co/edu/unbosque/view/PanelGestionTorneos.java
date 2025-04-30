package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelGestionTorneos extends JPanel {

    private JButton btnAgregar, btnEditar, btnEliminar, btnGenerarReporte;
    private JTable tablaDatos;
    private JScrollPane scrollTabla;

    private JComboBox<String> comboJuego, comboFecha, comboTipo, comboPais;

    public PanelGestionTorneos() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        // Logo y encabezado
        PanelConFondo panelLogo = new PanelConFondo("/imagenes/logoESport.png");
        panelLogo.setPreferredSize(new Dimension(900, 100));
        panelLogo.setLayout(new BorderLayout());
        add(panelLogo, BorderLayout.NORTH);

        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        panelCentral.setBackground(Color.WHITE);

        // Título
        JLabel lblTitulo = crearTitulo("Gestión de Torneos");
        panelCentral.add(Box.createVerticalStrut(20));
        panelCentral.add(lblTitulo);

        // Botones
        JPanel panelBotones = crearPanelBotones();
        panelCentral.add(Box.createVerticalStrut(20));
        panelCentral.add(panelBotones);

        // Panel de filtros con etiquetas y combos
        JPanel panelFiltros = new JPanel(new GridLayout(2, 4, 10, 10));
        panelFiltros.setMaximumSize(new Dimension(800, 60));
        panelFiltros.setBackground(Color.WHITE);

        panelFiltros.add(new JLabel("Juego:"));
        comboJuego = new JComboBox<>(new String[]{"Todos", "FIFA", "LoL", "Valorant"});
        panelFiltros.add(comboJuego);

        panelFiltros.add(new JLabel("Fecha:"));
        comboFecha = new JComboBox<>(new String[]{"Todas", "2024-01-01", "2024-06-10", "2024-12-31"});
        panelFiltros.add(comboFecha);

        panelFiltros.add(new JLabel("Tipo:"));
        comboTipo = new JComboBox<>(new String[]{"Todos", "Liga", "Eliminación", "Grupos"});
        panelFiltros.add(comboTipo);

        panelFiltros.add(new JLabel("País:"));
        comboPais = new JComboBox<>(new String[]{"Todos", "Colombia", "España", "México"});
        panelFiltros.add(comboPais);

        panelCentral.add(Box.createVerticalStrut(10));
        panelCentral.add(panelFiltros);

        // Tabla de datos
        String[] columnas = {"Nombre Torneo", "Juego", "Fecha","Pais", "Tipo", "Equipo 1", "Equipo 2"};
        tablaDatos = new JTable(new Object[0][columnas.length], columnas);
        scrollTabla = new JScrollPane(tablaDatos);
        scrollTabla.setPreferredSize(new Dimension(800, 200));
        panelCentral.add(Box.createVerticalStrut(10));
        panelCentral.add(scrollTabla);

        // Botón reporte
        btnGenerarReporte = new JButton("Generar reporte");
        btnGenerarReporte.setAlignmentX(Component.RIGHT_ALIGNMENT);
        btnGenerarReporte.setMaximumSize(new Dimension(200, 30));
        panelCentral.add(Box.createVerticalStrut(10));
        panelCentral.add(btnGenerarReporte);

        add(panelCentral, BorderLayout.CENTER);
    }

    private JLabel crearTitulo(String texto) {
        JLabel lbl = new JLabel(texto, SwingConstants.CENTER);
        lbl.setFont(new Font("Arial", Font.BOLD, 16));
        lbl.setOpaque(true);
        lbl.setBackground(new Color(220, 220, 220));
        lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        lbl.setMaximumSize(new Dimension(500, 30));
        return lbl;
    }

    private JLabel crearSubtitulo(String texto) {
        JLabel lbl = new JLabel(texto, SwingConstants.CENTER);
        lbl.setFont(new Font("Arial", Font.BOLD, 14));
        lbl.setOpaque(true);
        lbl.setBackground(new Color(240, 240, 240));
        lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        lbl.setMaximumSize(new Dimension(400, 25));
        return lbl;
    }

    private JPanel crearPanelBotones() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
        panel.setBackground(Color.WHITE);
        btnAgregar = crearBoton("Agregar");
        btnAgregar.setActionCommand("AgregarTorneo");
        btnEditar = crearBoton("Editar");
        btnEliminar = crearBoton("Eliminar");
        panel.add(btnAgregar);
        panel.add(btnEditar);
        panel.add(btnEliminar);
        return panel;
    }

    private JButton crearBoton(String texto) {
        JButton btn = new JButton(texto);
        btn.setPreferredSize(new Dimension(120, 30));
        btn.setFont(new Font("Arial", Font.BOLD, 13));
        return btn;
    }

    // --- Getters para controlador si los necesitas ---
    public JButton getBtnAgregar() { return btnAgregar; }
    public JButton getBtnEditar() { return btnEditar; }
    public JButton getBtnEliminar() { return btnEliminar; }
    public JButton getBtnGenerarReporte() { return btnGenerarReporte; }
    public JTable getTablaDatos() { return tablaDatos; }

    public JComboBox<String> getComboJuego() { return comboJuego; }
    public JComboBox<String> getComboFecha() { return comboFecha; }
    public JComboBox<String> getComboTipo() { return comboTipo; }
    public JComboBox<String> getComboPais() { return comboPais; }
}

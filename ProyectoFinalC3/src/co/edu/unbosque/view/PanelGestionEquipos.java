package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelGestionEquipos extends JPanel {

    private JButton btnAgregar, btnEditar, btnEliminar, btnGenerarReporte;
    private JTable tablaDatos;
    private JScrollPane scrollTabla;

    public PanelGestionEquipos() {
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
        JLabel lblTitulo = crearTitulo("Gestión de Equipos");
        panelCentral.add(Box.createVerticalStrut(20));
        panelCentral.add(lblTitulo);

        // Botones
        JPanel panelBotones = crearPanelBotones();
        panelCentral.add(Box.createVerticalStrut(20));
        panelCentral.add(panelBotones);

        // Filtros
        JLabel lblFiltros = crearSubtitulo("Filtros");
        panelCentral.add(Box.createVerticalStrut(15));
        panelCentral.add(lblFiltros);

        // Tabla
        String[] columnas = {"Nombre", "Juego", "Ciudad", "Entrenador"};
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
        btnAgregar.setActionCommand("AgregarEquipo");

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

    // --- Getters para el controlador ---
    public JButton getBtnAgregar() { return btnAgregar; }
    public JButton getBtnEditar() { return btnEditar; }
    public JButton getBtnEliminar() { return btnEliminar; }
    public JButton getBtnGenerarReporte() { return btnGenerarReporte; }
    public JTable getTablaDatos() { return tablaDatos; }
}

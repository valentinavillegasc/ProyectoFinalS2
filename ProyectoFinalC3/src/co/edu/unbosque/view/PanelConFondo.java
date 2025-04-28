package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelConFondo extends JPanel {

    private Image imagenFondo;

    public PanelConFondo(String rutaImagen) {
        setLayout(new BorderLayout());
        ImageIcon icono = new ImageIcon(getClass().getResource(rutaImagen));
        imagenFondo = icono.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
    }
}

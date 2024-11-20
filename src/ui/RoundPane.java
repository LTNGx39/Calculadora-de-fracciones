package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundPane extends javax.swing.JPanel {

    public RoundPane(Ventana ventana) {
        setSize(ventana.getWidth(), ventana.getHeight());
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        RoundRectangle2D border = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 22, 22);
        g2.setColor(Colors.BLACK);
        g2.fill(border);

        RoundRectangle2D rectangle = new RoundRectangle2D.Double(1, 1, getWidth() - 2, getHeight() - 2, 20, 20);
        g2.setColor(Colors.DARK_GRAY);
        g2.fill(rectangle);

    }

}

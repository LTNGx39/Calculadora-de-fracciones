package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

/**
 * JPanel donde se muestra el nombre de la aplicacion y el boton de salida
 */

public class TitleBar extends javax.swing.JPanel {

    Ventana ventana;
    JLabel title;
    JButton close;

    public TitleBar(Ventana ventana) {

        // Llenado de variables
        this.ventana = ventana;

        // Configuracion de barra de titulo
        setPreferredSize(new Dimension(ventana.getUsableWidth(), 40));
        setMinimumSize(getPreferredSize());
        setMaximumSize(getPreferredSize());
        setBorder(BorderFactory.createEmptyBorder(9, 31, 9, 9));
        setLayout(new GridBagLayout());
        setBackground(Colors.BLACK);
        setOpaque(false);

        // Configuracion de componentes
        title = new JLabel("Calculadora de fracciones");
        title.setPreferredSize(new Dimension(ventana.getUsableWidth() - 62, 22));
        title.setFont(new Font("Arial Nova", Font.BOLD, 16));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setForeground(Colors.WHITE);

        close = new JButton();
        close.setPreferredSize(new Dimension(22, 22));
        close.setBackground(Colors.RED);
        close.setFocusPainted(false);
        close.setBorderPainted(false);

        // Adicion de componentes
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(title, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(close, gbc);

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        RoundRectangle2D rounded = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20);
        Rectangle2D rectangle = new Rectangle2D.Double(0, getHeight() / 2, getWidth(), getHeight());
        
        g2.setColor(getBackground());
        g2.fill(rounded);
        g2.fill(rectangle);

    }

}

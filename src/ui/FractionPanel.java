package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class FractionPanel extends javax.swing.JPanel {

    private Ventana ventana;
    private CustomText n1, d1, n2, d2, n3, d3;
    private JLabel symbol, equal;

    public FractionPanel(Ventana ventana) {

        // Llenado de variables
        this.ventana = ventana;

        // Configuracion del panel
        setBorder(BorderFactory.createEmptyBorder(60, 100, 60, 100));
        setLayout(new GridBagLayout());
        setBackground(ventana.getBackground());

        // Configuracion de componentes
        n1 = new CustomText(ventana, "1");
        n2 = new CustomText(ventana, "2");
        n3 = new CustomText(ventana, "3");
        d1 = new CustomText(ventana, "4");
        d2 = new CustomText(ventana, "5");
        d3 = new CustomText(ventana, "6");

        symbol = new Label("+");
        equal = new Label("=");

        // Adicion de componentes
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;

        Insets bottom = new Insets(0, 0, 15, 0);
        Insets top = new Insets(15, 0, 0, 0);
        Insets none = new Insets(0, 0, 0, 0);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = bottom;
        add(n1, gbc);
        
        gbc.gridx = 1;
        gbc.gridheight = 2;
        gbc.insets = none;
        add(symbol, gbc);

        gbc.gridx = 2;
        gbc.gridheight = 1;
        gbc.insets = bottom;
        add(n2, gbc);

        gbc.gridx = 3;
        gbc.gridheight = 2;
        gbc.insets = none;
        add(equal, gbc);

        gbc.gridx = 4;
        gbc.gridheight = 1;
        gbc.insets = bottom;
        add(n3, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = top;
        add(d1, gbc);

        gbc.gridx = 2;
        add(d2, gbc);

        gbc.gridx = 4;
        add(d3, gbc);

    }
}

// Clase CustomText

class CustomText extends javax.swing.JTextField {

    public CustomText(Ventana ventana, String text) {

        super(text);

        setFont(new Font("Arial Nova", Font.BOLD, 36));
        setHorizontalAlignment(SwingConstants.CENTER);
        setForeground(Colors.WHITE);
        setBackground(Colors.GRAY);
        setBorder(BorderFactory.createEmptyBorder());
        setOpaque(false);

    }

    @Override
    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        RoundRectangle2D rounded = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20);
        g2.setColor(getBackground());
        g2.fill(rounded);

        super.paintComponent(g);

    }

}

// Clase Label

class Label extends javax.swing.JLabel {

    public Label(String text) {

        super(text);

        setFont(new Font("Arial Nova", Font.BOLD, 48));
        setHorizontalAlignment(SwingConstants.CENTER);
        setForeground(Colors.WHITE);

    }

}

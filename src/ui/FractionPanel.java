package ui;

import javax.swing.*;
import java.awt.*;

public class FractionPanel extends javax.swing.JPanel {

    private Ventana ventana;
    private CustomText n1, d1, n2, d2, n3, d3;
    private JLabel symbol, equal;

    public FractionPanel(Ventana ventana) {

        // Llenado de variables
        this.ventana = ventana;

        // Configuracion del panel
        setBorder(BorderFactory.createEmptyBorder(40, 80, 40, 80));
        setLayout(new GridBagLayout());
        setBackground(Colors.BLUE);

        // Configuracion de componentes
        n1 = new CustomText(ventana, "1");
        n2 = new CustomText(ventana, "2");
        n3 = new CustomText(ventana, "3");
        d1 = new CustomText(ventana, "4");
        d2 = new CustomText(ventana, "5");
        d3 = new CustomText(ventana, "6");

        symbol = new JLabel("+");
        equal = new JLabel("=");
        symbol.setBackground(Colors.WHITE);
        equal.setBackground(Colors.WHITE);
        symbol.setOpaque(true);
        equal.setOpaque(true);

        // Adicion de componentes
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(n1, gbc);
        
        gbc.gridx = 1;
        gbc.gridheight = 2;
        add(symbol, gbc);

        gbc.gridx = 2;
        gbc.gridheight = 1;
        add(n2, gbc);

        gbc.gridx = 3;
        gbc.gridheight = 2;
        add(equal, gbc);

        gbc.gridx = 4;
        gbc.gridheight = 1;
        add(n3, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
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

        setBackground(Colors.WHITE);
        setOpaque(true);

    }

}

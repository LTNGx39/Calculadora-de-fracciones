package ui;

import javax.swing.*;
import java.awt.*;

/**
 * Ventana donde se ve la ejecucion principal del programa
 */

public class Ventana extends javax.swing.JFrame {

    private int usableWidth, usableHeight;
    private TitleBar titleBar;
    private FractionPanel fractionPanel;
    private ButtonPanel buttonPanel;

    // Constructor para la ventana
    public Ventana() {

        // Tamaño de pantalla
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        screen.setSize(screen.width / 3, screen.width / 4);

        // Configuracion de ventana
        setSize(screen);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setContentPane(new RoundPane(this));
        setBackground(new Color(0, 0, 0, 0));

        // Llenado de variables
        usableWidth = getWidth() - 2;
        usableHeight = getHeight() - 2;

        // Creacion de paneles
        titleBar = new TitleBar(this);
        fractionPanel = new FractionPanel(this);
        buttonPanel = new ButtonPanel(this);

        // Adicion de paneles
        add(titleBar);
        add(fractionPanel);
        add(buttonPanel);

    }

    // Metodos
    public int getUsableWidth() {
        return usableWidth;
    }

    public int getUsableHeight() {
        return usableHeight;
    }

    public FractionPanel getFractionPanel() {
        return fractionPanel;
    }
}